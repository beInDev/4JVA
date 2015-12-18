<%@include file="Includes/header.jsp" %>

		<main class="mdl-layout__content">
			<div class="mdl-card mdl-shadow--6dp">
				<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
					<h2 class="mdl-card__title-text">Edit My Profile (<c:out value="${sessionScope.user.getUserName()}"/>)</h2>
				</div>
			  	<div class="mdl-card__supporting-text">
					<form method="POST" action="">
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="register_fname" value="<c:out value="${sessionScope.user.getFName()}"/>" />
							<label class="mdl-textfield__label" for="register_fname">First Name</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="register_lname" value="<c:out value="${sessionScope.user.getLName()}"/>" />
							<label class="mdl-textfield__label" for="register_lname">Last Name</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="register_email" value="<c:out value="${sessionScope.user.getEmail()}"/>"  />
							<label class="mdl-textfield__label" for="register_email">Email</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="register_postal" value="<c:out value="${sessionScope.user.getCodePostal()}"/>" />
							<label class="mdl-textfield__label" for="register_postal">Postal Code</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="password" id="register_password" value="<c:out value="${sessionScope.user.getPassword()}"/>" />
							<label class="mdl-textfield__label" for="register_password">Password</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="password" id="register_password_bis" />
							<label class="mdl-textfield__label" for="register_password_bis">Password (Again)</label>
						</div>
						<div class="mdl-card__actions mdl-card--border">
							<input type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" value="Save"></button>
						</div>
					</form>
				</div>
				
			</div>
		</main>

<%@include file="Includes/footer.jsp" %>