<%@include file="Includes/header.jsp" %>

=		<main class="mdl-layout__content">
			<div class="mdl-card mdl-shadow--6dp">
				<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
					<h2 class="mdl-card__title-text">Log In SupBartering</h2>
				</div>
				<c:if test="${requestScope.error== true}">
					<div class="mdl-textfield mdl-js-textfield">
						<p class="mdl-textfield__error">An error occurred while registering, please check your inputs and try again</p>
					</div>
				</c:if>
				<c:choose >
					<c:when test="${requestScope.passed== true || sessionScope.user != null}">
						<div class="mdl-textfield mdl-js-textfield">
							<p>Successfully logged in!</p>
						</div>
					</c:when>
					<c:otherwise>
					  	<div class="mdl-card__supporting-text">
							<form method="POST" action="">
								<div class="mdl-textfield mdl-js-textfield">
									<input class="mdl-textfield__input" type="text" id="login_username" />
									<label class="mdl-textfield__label" for="login_username">Username</label>
								</div>
								<div class="mdl-textfield mdl-js-textfield">
									<input class="mdl-textfield__input" type="password" id="login_password" />
									<label class="mdl-textfield__label" for="login_password">Password</label>
								</div>
								<div class="mdl-card__actions mdl-card--border">
									<input type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" value="Log in"></button>
								</div>
							</form>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</main>

<%@include file="Includes/footer.jsp" %>