<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/commons" prefix="cm" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <style>
            .ql-syntax {
                background-color: black;
                color: white;
                padding: 10px;
                border-radius: 4px;
                margin-top: 10px;
                margin-bottom: 10px;
                white-space: pre-wrap;
            }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Notes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
</head>

<body>
    <cm:header/>
    <div class="container-md mt-5">
        <div class="card border-0">
            <div class="card-body">
                <p class="card-text">
                    <div id="quill-editor" style="height: 80vh;">
                        <c:out value="${structures.notes}" escapeXml="false" />
                    </div>
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

    <!-- Initialize Quill on the specified element -->
    <script>
        var quill = new Quill('#quill-editor', {
            theme: 'bubble',
            readOnly: true,
        });
        quill.editor.disable();
    </script>

</body>

</html>
