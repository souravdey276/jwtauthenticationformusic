package com.dxc.music.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
        @Id
        private String email;
		private String firstname;
		private String lastname;
		
		private String password;
		private String gender;
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
					+ password + ", gender=" + gender + "]";
		}
		
		
}

