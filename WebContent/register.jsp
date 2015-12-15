<%@include file="Includes/header.jsp" %>

		<main class="mdl-layout__content">
			<div class="mdl-card mdl-shadow--6dp">
				<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
					<h2 class="mdl-card__title-text">Register SupBartering</h2>
				</div>
			  	<div class="mdl-card__supporting-text">
					<form action="register">
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="register_fname" required/>
							<label class="mdl-textfield__label" for="register_fname">First Name</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="register_lname" required />
							<label class="mdl-textfield__label" for="register_lname">Last Name</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="register_email" required />
							<label class="mdl-textfield__label" for="register_email">Email</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="register_postal" required />
							<label class="mdl-textfield__label" for="register_postal">Postal Code</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="email" id="register_username" required />
							<label class="mdl-textfield__label" for="register_username">Username</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="password" id="register_password" required />
							<label class="mdl-textfield__label" for="register_password">Password</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="password" id="register_password_bis" required />
							<label class="mdl-textfield__label" for="register_password_bis">Password (Again)</label>
						</div>
					</form>
				</div>
				<div class="mdl-card__actions mdl-card--border">
					<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Register</button>
				</div>
			</div>
		</main>

<%@include file="Includes/footer.jsp" %>