<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-04-30
  Time: 오후 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="robots" content="noindex, nofollow">
    <title>404 Not Found</title>
    <meta name="description" content="404 Not Found">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body class="py-5" onload="javascript:loadDomain();">
<!-- Error Page Content -->
<div class="container">
    <div class="hero text-center my-4">
        <h1 class="display-5"><i class="bi bi-emoji-dizzy text-danger mx-3"></i></h1>
        <h1 class="display-5 fw-bold">404 Not Found</h1>
        <p class="lead">We couldn't find what you're looking for on <em><span id="display-domain"></span></em>.
        </p>
        <p><btn onclick=javascript:goToHomePage(); class="btn btn-outline-success btn-lg">Go to Homepage</a></btn>
    </div>

    <div class="content">
        <div class="row  justify-content-center py-3">
            <div class="col-md-6">
                <div class="my-5 p-5 card">
                    <h3>What happened?</h3>
                    <p class="fs-5">A 404 error status implies that the file or page that you're looking for could not be found.</p>
                </div>
                <div class="my-5 p-5 card">
                    <h3>What can I do?</h3>
                    <p class="fs-4">If you're a site visitor</p>
                    <p>Please use your browser's back button and check that you're in the right place. If you need immediate assistance, please send us an email instead.</p>
                    <p class="fs-4">If you're the site owner</p>
                    <p>Please check that you're in the right place and get in touch with your website provider if you believe this to be an error.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function loadDomain() {
        var display = document.getElementById("display-domain");
        display.innerHTML = document.domain;
    }
    // CTA button actions
    function goToHomePage() {
        window.location = '/';
    }
    function reloadPage() {
        document.location.reload(true);
    }
</script>
</body>
</html>

