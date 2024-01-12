<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/commons" prefix="cm" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>FitZen</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script type="module" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>

<body>
    <cm:header/>
    <div class="container mt-5">
        <h2>List of Applications</h2>
    <div class="row">
        <div class="col">
            <a href="/applications/new" class="btn btn-primary mb-3">Add Application</a>
        </div>
        <div class="col">
            <form id="fileUploadForm" action="/api/data-structures/import" method="post" enctype="multipart/form-data"
                style="display: none;">
                <input type="file" id="fileInput" name="file" accept=".csv">
                <button type="submit" class="btn btn-primary mb-3">Upload</button>
            </form>
            <button id="showFormButton" class="btn btn-secondary mb-3">Show Upload Form</button>
        </div>
        <div class="col ml-auto">
            Todays Applications:
            <span class="d-flex align-items-center justify-content-center rounded-circle border border-primary p-3"
                style="width: 50px; height: 50px; background-color: #3498db; color: #ffffff;">
                ${todaysApplications}
            </span>
        </div>
        <div class="col ml-auto">
            Total Applications:
            <span class="d-flex align-items-center justify-content-center rounded-circle border border-primary p-3"
                style="width: 50px; height: 50px; background-color: #3498db; color: #ffffff;">
                ${totalApplications}
            </span>
        </div>
    </div>
		<script>
		    document.getElementById('showFormButton').addEventListener('click', function() {
		        document.getElementById('fileUploadForm').style.display = 'block';
		    });
		</script>
        <table class="table">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Company</th>
                    <th>Status</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="application" items="${applications}">
                    <tr>
                        <td>${application.title}</td>
                        <td>${application.company}</td>
                        <td>${application.status}</td>
                        <td>
                            <a type="submit" class="btn btn-secondary" href="${application.link}">URL</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>
