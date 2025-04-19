// PremiumMember class extends GymMember class
public class PremiumMember extends GymMember{
        // Declaring attributes
        private final double premiumCharge = 50000; // Fixed premium charge
        private String personalTrainer; // Name of personal trainer
        private boolean isFullPayment; // Checks if payment is fully done
        private double paidAmount; 
        private double discountAmount; 
        
        // Constructor with parameters
        public PremiumMember(int id, String name, String location, String phone, String email, String gender,
                             String DOB, String membershipStartDate, String personalTrainer)
                             
            // Calling the constructor of superclass GymMember
            {
            super(id, name, location, phone, email, gender, DOB, membershipStartDate);
            this.personalTrainer = personalTrainer;
            this.paidAmount = 0; // Initially, no amount is paid
            this.isFullPayment = false; // Initially, payment is not full
            this.discountAmount = 0; // No discount initially
        
            } 
            
            
             // Accessor methods
        public double getPremiumCharge() 
        { return premiumCharge; }
        
        public String getPersonalTrainer() 
        { return personalTrainer; }
        
        public boolean getIsFullPayment() 
        { return isFullPayment; }
        
        public double getPaidAmount() 
        { return paidAmount; }
        
        public double getDiscountAmount()
        { return discountAmount; }
            
         @Override
        public void markAttendance() {
            this.attendance++;
            this.loyaltyPoints += 10;
        }
    
        // Method to pay the due amount
        public String payDueAmount(double paidAmount) {
            // Check if payment is already full
            if (this.isFullPayment) {
                return "Payment is already complete. No further payment required.";
            }
    
            // Add the paidAmount to the total paidAmount
            double totalPaid = this.paidAmount + paidAmount;    
            // Check if paidAmount exceeds premiumCharge
            
           if (totalPaid > this.premiumCharge) {
            return "Payment exceeds the premium charge.";
             }
    
            // Calculate remaining amount
            double remainingAmount = premiumCharge - this.paidAmount;
    
            // Check if payment is now full
             this.paidAmount = totalPaid;
            if (this.paidAmount == this.premiumCharge) {
                this.isFullPayment = true; // Update isFullPayment to true
                return "Payment successful! No there is remaining amount. Payment is now complete.";
            } else {
                return "Payment successful! Remaining amount to be paid: " + remainingAmount;
            }
        }
    
        // Method to calculate discount
        public void calculateDiscount() {
            // Check if payment is full
            if (this.isFullPayment) {
                this.discountAmount = premiumCharge * 0.10; // 10% discount
                System.out.println("Discount calculated successfully: " + this.discountAmount);
            } else {
                System.out.println("No discount applicable. Payment is not complete.");
            }
        }
    
        // Method to revert premium member details
        public void revertPremiumMember() {
            super.resetMember(); // Call superclass reset method
            this.personalTrainer = ""; // Reset personal trainer
            this.isFullPayment = false; // Reset isFullPayment
            this.paidAmount = 0; // Reset paidAmount
            this.discountAmount = 0; // Reset discountAmount
        }
    
        // Method to display PremiumMember details
        @Override
        public void display() {
            super.display(); // Call superclass display method
            System.out.println("Personal Trainer: " + personalTrainer);
            System.out.println("Paid Amount: " + paidAmount);
            System.out.println("Is Full Payment: " + isFullPayment);
    
            // Calculate and display remaining amount
            double remainingAmount = premiumCharge - this.paidAmount;
            System.out.println("Remaining Amount to be Paid: " + remainingAmount);
    
            // Display discountAmount only if payment is complete
            if (this.isFullPayment) {
                System.out.println("Discount Amount: " + discountAmount);
            }
        }
}
