package servlets;

import main.Tweet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by david_szilagyi on 2017.05.03..
 */
public class TweetServlet extends HttpServlet {
    List<Tweet> tweets = new ArrayList<>();
    List<Tweet> filteredTweets;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String poster = request.getParameter("poster");
        String content = request.getParameter("content");
        if (poster != null && content != null) {
            tweets.add(0, new Tweet(poster, content, new Date()));
        }
        response.sendRedirect("/tweet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int start = 0;
        int stop = tweets.size();
        String user = "";
        if (request.getParameter("limit") != null && request.getParameter("offset") != null) {
            start = Integer.valueOf(request.getParameter("offset"));
            stop = Integer.valueOf(request.getParameter("limit"));
            if (stop > tweets.size()) {
                stop = tweets.size();
            }
            if (start > tweets.size()) {
                start = 0;
            }
        }
        if (request.getParameter("user") != null) {
            user = request.getParameter("user");
        }
        filterTweets(start, stop, user);
        request.setAttribute("filtered", filteredTweets);
        RequestDispatcher rd = request.getRequestDispatcher("tweet.jsp");
        rd.forward(request, response);
    }

    protected void filterTweets(int offset, int limit, String user) {
        filteredTweets = new ArrayList<>();
        for (int index = offset; index < limit; index++) {
            if (!user.equals("")) {
                if (tweets.get(index).getName().equals(user)) {
                    filteredTweets.add(tweets.get(index));
                }
            } else {
                filteredTweets.add(tweets.get(index));
            }
        }
    }
}
