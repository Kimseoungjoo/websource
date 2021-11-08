package member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateDTO {
	private String userid;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	
	public boolean passwordEqualTo(String confirmPassword) {
		return this.newPassword.equals(confirmPassword);
	}
}
