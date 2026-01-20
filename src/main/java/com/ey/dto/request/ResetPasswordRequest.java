package com.ey.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ResetPasswordRequest implements Serializable {

	    private static final long serialVersionUID = 1L;

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    private String email;

	    @NotBlank(message = "Old password is required")
	    private String oldPassword;
	    @NotBlank(message = "New password is required")
	    private String newPassword;
		public ResetPasswordRequest(
				@Email(message = "Invalid email format") @NotBlank(message = "Email is required") String email,
				@NotBlank(message = "Old password is required") String oldPassword,
				@NotBlank(message = "New password is required") String newPassword) {
			super();
			this.email = email;
			this.oldPassword = oldPassword;
			this.newPassword = newPassword;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getOldPassword() {
			return oldPassword;
		}
		public void setOldPassword(String oldPassword) {
			this.oldPassword = oldPassword;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
		@Override
		public String toString() {
			return "ResetPasswordRequest [email=" + email + ", oldPassword=" + oldPassword + ", newPassword="
					+ newPassword + "]";
		}

}
