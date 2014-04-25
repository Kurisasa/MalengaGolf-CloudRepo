/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.golfkids.servlet;

import com.boha.golfkids.dto.AgeGroupDTO;
import com.boha.golfkids.dto.CountryDTO;
import com.boha.golfkids.dto.RequestDTO;
import com.boha.golfkids.dto.ResponseDTO;
import com.boha.golfkids.util.DataException;
import com.boha.golfkids.util.DataUtil;
import com.boha.golfkids.util.DuplicateException;
import com.boha.golfkids.util.GZipUtility;
import com.boha.golfkids.util.LeaderBoardUtil;
import com.boha.golfkids.util.PlatformUtil;
import com.google.gson.Gson;
import com.oreilly.servlet.ServletUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AubreyM
 */
@WebServlet(name = "GolfAdminServlet", urlPatterns = {"/admin"})
public class GolfAdminServlet extends HttpServlet {

    @EJB
    DataUtil dataUtil;
    @EJB
    LeaderBoardUtil leaderBoardUtil;
    @EJB
    PlatformUtil platformUtil;

    /**
     *
     * Serves as the main administration servlet
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long start = System.currentTimeMillis();
        Gson gson = new Gson();
        ResponseDTO resp = new ResponseDTO();
        RequestDTO dto = getRequest(gson, request);
        //
        if (dto == null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("Bad Request, nobody's home for you!");
            platformUtil.addErrorStore(9, "Bad, rogue request detected", "GolfAdminServlet");
            out.close();
        } else {
            log.log(Level.WARNING, "---> GolfAdminServlet started ... requestType: {0}", dto.getRequestType());
            try {
                switch (dto.getRequestType()) {
                    case RequestDTO.UPDATE_TEE_TIMES:
                        resp = dataUtil.updateTeeTime(dto.getTourneyScoreByRound());
                        break;
                    case RequestDTO.CLOSE_TOURNAMENT:
                        resp = dataUtil.closeTournament(dto.getTournamentID(), leaderBoardUtil);
                        break;
                    case RequestDTO.UPDATE_WINNER_FLAG:
                        resp = dataUtil.updateWinnerFlag(dto.getLeaderBoardID(), dto.getWinnerFlag());
                        break;

                    case RequestDTO.GET_GOLF_GROUP_DATA:
                        resp = dataUtil.getGolfGroupData(dto.getGolfGroupID(),
                                dto.getCountryID());
                        break;
                    case RequestDTO.GET_LEADERBOARD:
                        resp = leaderBoardUtil.getSectionedLeaderBoards(dto.getTournamentID(), dataUtil);
                        break;
                    case RequestDTO.GET_LEADERBOARD_BOYS:
                        break;
                    case RequestDTO.GET_LEADERBOARD_GIRLS:
                        break;
                    case RequestDTO.UPDATE_TOURNAMENT_SCORES:
                        resp = dataUtil.updateTournamentScoreByRound(dto.getLeaderBoard());
                        break;
                    case RequestDTO.UPDATE_TOURNAMENT_SCORE_TOTALS:
                        resp = dataUtil.updateTournamentScore(dto.getLeaderBoard());
                        break;
                    case RequestDTO.ADD_TOURNAMENT_PLAYERS:
                        resp = dataUtil.addTournamentPlayer(dto.getLeaderBoard());
                        break;

                    case RequestDTO.ADD_TOURNAMENT:
                        resp = dataUtil.addTournament(dto.getTournament());

                        break;
                    case RequestDTO.ADD_PLAYER:
                        resp = dataUtil.addPlayer(dto.getPlayer(), dto.getGolfGroupID());
                        break;
                    case RequestDTO.UPDATE_PLAYER:
                        dataUtil.updatePlayer(dto.getPlayer());
                        break;

                    case RequestDTO.ADD_PARENT:
                        resp = dataUtil.addParent(dto.getParent(), dto.getGolfGroupID());
                        break;
                    case RequestDTO.UPDATE_PARENT:
                        dataUtil.updateParent(dto.getParent());
                        break;
                    case RequestDTO.ADMIN_LOGIN:
                        resp = dataUtil.signInAdministrator(dto.getEmail(), dto.getPin());
                        break;
                    case RequestDTO.ADD_ADMINISTRATOR:
                        resp = dataUtil.addGolfGroupAdmin(dto.getAdministrator());

                        break;
                    case RequestDTO.ADD_GOLF_GROUP:
                        resp = dataUtil.addGolfGroup(dto.getGolfGroup(), dto.getAdministrator());

                        break;
                    case RequestDTO.UPDATE_GOLF_GROUP:
                        dataUtil.updateGolfGroup(dto.getGolfGroup());
                        break;
                    case RequestDTO.ADD_CLUB:
                        resp = dataUtil.addClub(dto.getClub());
                        break;
                    case RequestDTO.GET_CLUBS_IN_COUNTRY:
                        resp = dataUtil.getClubsByCountry(dto.getCountryID());
                        break;

                    case RequestDTO.UPDATE_PLAYER_PARENT:
                        //TODO - think!
                        break;
                    case RequestDTO.UPDATE_ADMINISTRATOR:
                        dataUtil.updateAdmin(dto.getAdministrator());
                        break;
                    case RequestDTO.UPDATE_CLUB:
                        dataUtil.updateClub(dto.getClub());
                        break;
                    case RequestDTO.GET_AGE_GROUPS:
                        List<AgeGroupDTO> ageList = dataUtil.getAgeGroups(dto.getGolfGroupID());
                        resp.setAgeGroups(ageList);
                        break;
                    case RequestDTO.GET_AGE_GROUPS_BOYS:
                        List<AgeGroupDTO> ageList1 = dataUtil.getAgeGroupsBoys(dto.getGolfGroupID());
                        resp.setAgeGroups(ageList1);
                        break;
                    case RequestDTO.GET_AGE_GROUPS_GIRLS:
                        List<AgeGroupDTO> ageList2 = dataUtil.getAgeGroupsGirls(dto.getGolfGroupID());
                        resp.setAgeGroups(ageList2);
                        break;
                    case RequestDTO.GET_COUNTRIES:
                        List<CountryDTO> cntrList = dataUtil.getCountries();
                        resp.setCountries(cntrList);
                        break;

                    case RequestDTO.ADD_SCORER:
                        resp = dataUtil.addScorer(dto.getScorer(), dto.getGolfGroupID());
                        break;
                    case RequestDTO.UPDATE_SCORER:
                        dataUtil.updateScorer(dto.getScorer());
                        break;

                    case RequestDTO.GET_TOURNAMENT_PLAYERS:
                        resp = dataUtil.getTournamentPlayers(dto.getTournamentID());
                        break;
                    case RequestDTO.REMOVE_TOURNAMENT_PLAYER:
                        resp = dataUtil.removeTournamentPlayer(dto.getTournamentID(),
                                dto.getPlayerID());
                        break;
                    case RequestDTO.UPDATE_TOURNAMENT:
                        resp = dataUtil.updateTournament(dto.getTournament());
                        break;
                    case RequestDTO.GET_PLAYER_HISTORY:
                        resp = leaderBoardUtil.getPlayerHistory(dto.getPlayerID());
                        break;
                    case RequestDTO.ADD_VIDEO_CLIP:
                        resp = dataUtil.addVideoClip(dto.getVideoClip());
                        break;
                    case RequestDTO.GET_VIDEO_CLIPS_BY_GOLF_GROUP:
                        resp = dataUtil.getVideoClips(dto.getGolfGroupID());
                        break;
                    default:
                        platformUtil.addErrorStore(7, "Request Type specified not on", "GolfAdminServlet");
                        resp.setStatusCode(7);
                        break;
                }

            } catch (DataException e) {
                resp.setStatusCode(ResponseDTO.DATA_EXCEPTION);
                resp.setMessage("Database failed. Please try again later");
                log.log(Level.SEVERE, "Database failed", e);
                platformUtil.addErrorStore(8, "Database related error\n"
                        + e.description, "GolfAdminServlet");

            } catch (Exception e) {
                resp.setStatusCode(ResponseDTO.GENERIC_EXCEPTION);
                resp.setMessage("Server process failed. Please try again later");
                log.log(Level.SEVERE, "Server failed", e);
                platformUtil.addErrorStore(8, "Generic server app error\n"
                        + dataUtil.getErrorString(e), "GolfAdminServlet");
            } finally {
                String json = gson.toJson(resp);
                if (dto.isZippedResponse()) {
                    response.setContentType("application/zip;charset=UTF-8");
                    File zipped;
                    try {
                        zipped = GZipUtility.getZipped(json);
                        ServletUtils.returnFile(zipped.getAbsolutePath(), response.getOutputStream());
                        response.getOutputStream().close();
                        log.log(Level.OFF, "### Zipped Length of Response: {0} -  "
                                + "unzipped length: {1}", new Object[]{zipped.length(), json.length()});
                    } catch (Exception e) {
                        log.log(Level.SEVERE, "Zipping problem - probably the zipper cannot find the zipped file", e);
                        PrintWriter out = response.getWriter();
                        response.setContentType("application/json;charset=UTF-8");
                        out.println(json);
                        out.close();
                    }
                } else {
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println(json);
                    out.close();
                }

                long end = System.currentTimeMillis();
                platformUtil.addTimeElapsedWarning(start, end, dto, "GolfAdminServlet");
                log.log(Level.INFO, "---> GolfAdminServlet completed in {0} seconds", getElapsed(start, end));
            }
        }
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }

    private RequestDTO getRequest(Gson gson, HttpServletRequest req) {

        String json = req.getParameter("JSON");
        RequestDTO cr = gson.fromJson(json, RequestDTO.class);

        if (cr == null) {
            cr = new RequestDTO();
        }

        return cr;
    }
    private static final Logger log = Logger.getLogger("GolfAdmin");
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
