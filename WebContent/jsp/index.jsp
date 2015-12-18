<%@include file="Includes/header.jsp" %>
<c:set var="totalUsers" scope="application" value="<%= request.getAttribute("totalUsers") %>"/>
<c:set var="totalObjects" scope="application" value="<%= request.getAttribute("totalObjects") %>"/>
<c:set var="lastObject" scope="application" value="<%= request.getAttribute("lastObject") %>"/>
    <main class="mdl-layout__content">
    
       	<div class="mdl-layout__tab-panel is-active" id="overview">
       	
			<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
	            <div class="mdl-card mdl-cell mdl-cell--12-col">
		              <div class="mdl-card__supporting-text">
		                <h4>About SUP'Bartering</h4>
		                Dolore ex deserunt aute fugiat aute nulla ea sunt aliqua nisi cupidatat eu. Nostrud in laboris labore nisi amet do dolor eu fugiat consectetur elit cillum esse. Pariatur occaecat nisi laboris tempor laboris eiusmod qui id Lorem esse commodo in. Exercitation aute dolore deserunt culpa consequat elit labore incididunt elit anim.
		              </div>
		              <div class="mdl-card__actions">
		                <a href="<c:url value="browse"/>" class="mdl-button">Browse last added objects</a>
		              </div>
		         </div>
	        </section>
	         
	        <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
				<div class="mdl-card mdl-cell mdl-cell--12-col">
  					<div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
						<h4 class="mdl-cell mdl-cell--12-col">Statistics</h4>
						<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
							<h5>Total users:</h5>
							<h3><c:out value="${totalUsers}"/></h3>
						</div>
						<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
						  <h5>Total objects:</h5>
						  <h3><c:out value="${totalObjects}"/></h3>
						</div>
					</div>
					<div class="mdl-card__actions">
					  <a href="<c:url value="register"/>" class="mdl-button">Join us !</a>
					</div>
				</div>
			</section>
			<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
				<div class="mdl-card mdl-cell mdl-cell--12-col">
  					<div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
						<h4 class="mdl-cell mdl-cell--12-col">The Last Added object</h4>
						<div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
							  <h4><c:out value="${lastObject.getTitle()}"></c:out></h4>
							  <p><c:out value="${lastObject.getDescription()}"/></p>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>
<%@include file="Includes/footer.jsp" %>