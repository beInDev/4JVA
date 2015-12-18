<%@include file="Includes/header.jsp" %>
	<main class="mdl-layout__content">
	
	  	<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
	            <div class="mdl-card mdl-cell mdl-cell--12-col">
	              <div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
	                <h4 class="mdl-cell mdl-cell--12-col">My Objects</h4>
	                <c:if test="${requestScope.removed == true}">
	                	<p>The item has been deleted correctly.</p>
	                </c:if>
	                <c:forEach var="item" items="${requestScope.items}">
		                <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone">
		                  <div class="section__circle-container__circle mdl-color--primary"></div>
		                </div>
		                <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
		                  <h5><c:out value="${item.getTitle()}"/></h5>
		                  <p><c:out value="${item.getDescription()}"/></p>
		                  <p><a href="<c:url value="/myobjects?delete=${item.getItemId()}"/>">Delete my object</a></p>
		                </div>
	                </c:forEach>    
	                <section>      
		                <div class="mdl-card mdl-shadow--6dp">
		                    <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
		                        <h2 class="mdl-card__title-text">Submit a new Object</h2>
		                    </div>
		                    <div class="mdl-card__supporting-text">
		                        <form method="POST" action="">
		                            <div class="mdl-textfield mdl-js-textfield">
		                                <input class="mdl-textfield__input" type="text" id="create_title" required/>
		                                <label class="mdl-textfield__label" for="create_title">Title</label>
		                            </div>
		                            <div class="mdl-textfield mdl-js-textfield">
		                                <input class="mdl-textfield__input" type="text" id="create_description" required />
		                                <label class="mdl-textfield__label" for="create_description">Description</label>
		                            </div>
		                            <div class="mdl-textfield mdl-js-textfield">
		                                <input class="mdl-textfield__input" type="text" id="create_type" required/>
		                                <label class="mdl-textfield__label" for="create_type">Type</label>
		                            </div>
		                            <div class="mdl-textfield mdl-js-textfield">
		                                <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="create_price" required />
		                                <label class="mdl-textfield__label" for="create_price">Price</label>
		                            </div>
		                            <div class="mdl-textfield mdl-js-textfield">
		                                <input class="mdl-textfield__input" type="text" id="create_imageUrl" required/>
		                                <label class="mdl-textfield__label" for="create_imageUrl">URL of your image</label>
		                            </div>
		                            <div class="mdl-card__actions mdl-card--border">
				                        <input type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" value="Create"/>
				                    </div>
		                        </form>
		                    </div>
		                    
		                </div>
		            </section>
	               </div>
	             </div>
	          </section>
	    </main>

<%@include file="Includes/footer.jsp" %>