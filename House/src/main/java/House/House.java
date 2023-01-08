package House;

public class House {
	
	    private int id;
		private String type;
		private String address;
		private String description;
		private String price;
		private String phoneNo;
	    private String email;
	    
	    public House(int id, String type, String address, String description, String price, String phoneNo, String email) {
			super();
			this.id = id;
			this.type = type;
			this.address = address;
			this.description = description;
			this.price = price;
			this.phoneNo = phoneNo;
			this.email = email;
		}
	    
	    public House(String type, String address, String description, String price, String phoneNo, String email) {
			super();
			this.type = type;
			this.address = address;
			this.description = description;
			this.price = price;
			this.phoneNo = phoneNo;
			this.email = email;
		}


		public int getId() {
			return id;
		}
		public String getType() {
			return type;
		}
		public String getAddress() {
			return address;
		}
		public String getDescription() {
			return description;
		}
		public String getPrice() {
			return price;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public String getEmail() {
			return email;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setType(String type) {
			this.type = type;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    
	    
	}



