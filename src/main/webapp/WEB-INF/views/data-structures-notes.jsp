<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/commons" prefix="cm" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Data Structure Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <cm:header/>
    <div class="container-md mt-5">
        <div class="card border-0">
            <div class="card-body">
                <p class="card-text">
                    <c:out value="${structures.notes}" escapeXml="false" />
                </p>
            </div>
        </div>

        <!-- Edit Button -->
        <a href="/data-structures/${structures.id}/edit" class="btn btn-warning mt-3">Edit</a>

        <!-- Back to List Button -->
        <a href="/data-structures" class="btn btn-primary mt-3">Back to List</a>
        
        <!-- Export Button -->
        <a href="/api/data-structures/${structures.id}/export" class="btn btn-secondary mt-3">Export</a>
        
    </div>

</body>

</html>
