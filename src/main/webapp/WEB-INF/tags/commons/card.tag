    <%@ tag description="Reusable Card Component" pageEncoding="UTF-8"%>
    <%@ attribute name="imageSrc" required="false" rtexprvalue="true" type="java.lang.String" description="Image source for card" %>
    <%@ attribute name="title" required="false" rtexprvalue="true" type="java.lang.String" description="Card title" %>
    <%@ attribute name="text" required="false" rtexprvalue="true" type="java.lang.String" description="Card text" %>
    <%@ attribute name="backgroundColor" required="false" rtexprvalue="true" type="java.lang.String" description="Background color for the card" %>
    <%@ attribute name="marginTop" required="false" rtexprvalue="true" type="java.lang.String" description="Top margin for the card" %>
    <%@ attribute name="textColor" required="false" rtexprvalue="true" type="java.lang.String" description="Text color for the card" %>
    <%@ attribute name="buttonText" required="false" rtexprvalue="true" type="java.lang.String" description="Text for the optional button" %>
    <%@ attribute name="buttonHref" required="false" rtexprvalue="true" type="java.lang.String" description="Link for the optional button" %>

<div class="card<%= (marginTop != null && !marginTop.isEmpty()) ? " mt-" + marginTop : "" %>"
     style="width: 18rem; <%= (backgroundColor != null && !backgroundColor.isEmpty()) ? "background-color: " + backgroundColor + ";" : "" %>; border-radius: 10px;">
     <% if (imageSrc != null && !imageSrc.isEmpty()) { %>
            <img class="card-img-top" src="<%= imageSrc %>" alt="Card image cap">
        <% } %>
        <div class="card-body" <%= (textColor != null && !textColor.isEmpty()) ? "style=\"color: " + textColor + ";\"" : "" %>>
            <% if (title != null && !title.isEmpty()) { %>
                <h5 class="card-title"><%= title %></h5>
            <% } %>
            <% if (text != null && !text.isEmpty()) { %>
                <p class="card-text"><%= text %></p>
            <% } %>
            <% if (buttonText != null && !buttonText.isEmpty() && buttonHref != null && !buttonHref.isEmpty()) { %>
                <a href="<%= buttonHref %>" class="btn btn-light"><%= buttonText %></a>
            <% } %>
        </div>
    </div>
