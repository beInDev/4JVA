<%@include file="Includes/header.jsp" %>

<main class="mdl-layout__content">
	
	  	<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
	            <div class="mdl-card mdl-cell mdl-cell--12-col">
	              <div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
	                <h4 class="mdl-cell mdl-cell--12-col">Last added objects</h4>
	                <c:forEach var="item" items="${requestScope.items}">
		                <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone">
		                  <div class="section__circle-container__circle mdl-color--primary"></div>
		                </div>
		                <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
		                  <h5><c:out value="${item.getTitle()}"/></h5>
		                  <p><c:out value="${item.getDescription()}"/></p>
		                </div>
	                </c:forEach>  
	              </div>
	    
	            </div>
	          
	          </section>
	    </main>

<%@include file="Includes/footer.jsp" %>