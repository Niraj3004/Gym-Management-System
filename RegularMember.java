// RegularMember class extending GymMember
public class RegularMember extends GymMember{
        // Private attributes specific to RegularMember
        private final int attendanceLimit; // Final attribute (cannot be changed after initialization)
        private boolean isEligibleForUpgrade; 
        private String removalReason; 
        private String referralSource; 
        private String plan; 
        private double price; 
        
         // Constructor to initialize RegularMember attributes
        public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB,
                             String membershipStartDate, String referralSource)
        {
            super(id, name, location, phone, email,gender,DOB, membershipStartDate); // Call superclass constructor with 8 parameters
            this.attendanceLimit = 30; // Set attendanceLimit to 30
            this.isEligibleForUpgrade = false; // Set isEligibleForUpgrade to false
            this.removalReason = ""; // Set removalReason to empty
            this.referralSource = referralSource; // Assign referralSource from parameter
            this.plan = "Basic"; // Set plan to "Basic"
            this.price = 6500.0; // Set price to 6500
        }
    
          // Accessor methods (getters) for private attributes
        public int getAttendanceLimit() {
            return attendanceLimit;
        }
    
        public boolean isEligibleForUpgrade() {
            return isEligibleForUpgrade;
        }
    
        public String getRemovalReason() {
            return removalReason;
        }
    
        public String getReferralSource() {
            return referralSource;
        }
    
        public String getPlan() {
            return plan;
        }
    
        public double getPrice() {
            return price;
        }
        
       @Override
        public void markAttendance() {
            this.attendance++;
            this.loyaltyPoints += 5;
        }
    
       
           // Method to retrieve the price of a plan
        public double getPlanPrice(String plan) {
            switch (plan) {
                case "basic":
                    return 6500.0;
                case "standard":
                    return 12500.0;
                case "deluxe":
                    return 18500.0;
                default:
                    return -1; // Invalid plan
            }
        }
        
              // Method to upgrade membership plan
        public String upgradePlan(String plan) {
            if (!isEligibleForUpgrade) { // Check if eligible for upgrade
                return "You are not eligible for an upgrade yet.";
            }
            if (this.plan.equals(plan)) { // Check if already subscribed to the plan
                return "You are already subscribed to this plan.";
            }
            double price = getPlanPrice(plan); // Get price for the new plan
            if (price == -1) { // Check if plan is valid
                return "Invalid plan.";
            }
            this.plan = plan; // Update plan
            this.price = price; // Update price
            return "Plan upgraded successfully.";
        }
           
        // Method to revert a regular member
        public void revertRegularMember(String removalReason) {
            // Call superclass method resetMember()
            resetMember();
            // Reset attributes
            isEligibleForUpgrade = false;
            plan = "basic";
            price = 6500;
            this.removalReason = removalReason; // Assign removalReason from parameter
        }
        
        
        @Override
        public void display() {
        super.display(); // Call superclass display method
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) { // Check if removal reason is set
            System.out.println("Removal Reason: " + removalReason);
        }
    }

}