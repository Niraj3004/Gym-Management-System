public abstract class GymMember{
         // Protected attributes (accessible within the class and subclasses)
        protected int id;
        protected String name;
        protected String location;
        protected String phone;
        protected String email;
        protected String gender;
        protected String DOB;
        protected String membershipStartDate;
        protected int attendance;
        protected double loyaltyPoints;
        protected boolean activeStatus;
        
        
         public GymMember(int id, String name, String location, String phone, String email,String gender, String DOB, String membershipStartDate) {
            this.id = id;
            this.name = name;
            this.location = location;
            this.phone = phone;
            this.email = email;
            this.gender = gender;
            this.DOB = DOB;
            this.membershipStartDate = membershipStartDate;
            this.attendance = 0;        // Initialize attendance to 0
            this.loyaltyPoints = 0.0;   // Initialize loyalty points to 0
            this.activeStatus = false;  // Set active status to false by default
         }
        
        // Accessor methods (getters) for all attributes
        public int getId() {
            return id;
         }
    
        public String getName() {
         return name;
        }
    
        public String getLocation() {
            return location;
        }
    
        public String getPhone() {
            return phone;
        }
    
        public String getEmail() {
            return email;
        }
    
        public String getGender() {
            return gender;
        }
    
        public String getDOB() {
            return DOB;
        }
    
        public String getMembershipStartDate() {
            return membershipStartDate;
        }
    
        public int getAttendance() {
            return attendance;
        }
    
        public double getLoyaltyPoints() {
            return loyaltyPoints;
        }
    
        public boolean isActiveStatus() {
            return activeStatus;
        }
    
        // Abstract method to track attendance (to be implemented by subclasses)
        public abstract void markAttendance();
         
     
         public void activateMembership() {
            this.activeStatus = true; // Sets activeStatus to true
            System.out.println("Membership activated.");
        }
    
        public void deactivateMembership() {
            if (this.activeStatus) { // Checks if membership is active before deactivating
                this.activeStatus = false;  // Sets activeStatus to false
                System.out.println("Membership deactivated.");
            } else {
                System.out.println("Membership is already deactivated.");
            }
         }
        //reset method
         public void resetMember() {
            this.activeStatus = false;
            this.attendance = 0;
            this.loyaltyPoints = 0;
        }
        // Method to display member details
        public void display() {
            System.out.println("Member Details:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Location: " + location);
            System.out.println("Phone: " + phone);
            System.out.println("Email: " + email);
            System.out.println("Gender: " + gender);
            System.out.println("DOB: " + DOB);
            System.out.println("Membership Start Date: " + membershipStartDate);
            System.out.println("Attendance: " + attendance);
            System.out.println("Loyalty Points: " + loyaltyPoints);
            System.out.println("Active Status: " + activeStatus);
         }
}
