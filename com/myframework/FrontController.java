package com.myframework;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupérer le contexte (ex: /monframework)
        String context = request.getContextPath();

        // Récupérer l'URI complète
        String uri = request.getRequestURI();

        // Enlever le contexte pour obtenir la route propre
        String path = uri.substring(context.length());

        // Définir le type de réponse et afficher le chemin
        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("Chemin demandé : " + path);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // pour gérer POST de la même façon
    }
}
