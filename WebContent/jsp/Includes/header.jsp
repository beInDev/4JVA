<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!doctype html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <title>SUP'Bartering</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="Static/images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="Static/images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="<c:url value="Static/styles/material.min.css"/>" />
    <link type="text/css" rel="stylesheet" href="<c:url value="Static/styles/styles.css"/>" />
   
  </head>
  <body class="mdl-demo mdl-color--grey-100 mdl-color-text--grey-700 mdl-base">
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
      <header class="mdl-layout__header mdl-layout__header--scroll mdl-color--primary">
        <div class="mdl-layout--large-screen-only mdl-layout__header-row">
          <h3>SUP'Bartering</h3>
          <nav class="mdl-navigation">
	          <a href="<%=request.getContextPath()%>/" class="mdl-navigation__link is-active">Index</a>
	          <!-- hidden when logged in -->
	          <a href="<%=request.getContextPath()%>/login" class="mdl-navigation__link" >Login</a>
	          <a href="<%=request.getContextPath()%>/register" class="mdl-navigation__link">Register</a>
	          <!-- hidden when not logged in -->
	          <a href="<%=request.getContextPath()%>/browse" class="mdl-navigation__link">Browse objects</a>
	          <a href="<%=request.getContextPath()%>/myobjects" class="mdl-navigation__link">My Objects</a>
	          <a href="<%=request.getContextPath()%>/profile" class="mdl-navigation__link">My profile</a>
        	</nav>
        </div>
        
      </header>