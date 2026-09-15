package access_specifiers.class_problems;
public class LibraryMemberBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberBean() {
        this(null, null);
    }

    public LibraryMemberBean(String name) {
        this(null, name);
    }

    public LibraryMemberBean(String membershipId, String name) {
        this.name = name;
        if (membershipId != null) {
            this.membershipId = membershipId;
        }
    }

    public String getMembershipId() {
        return this.membershipId;
    }

    public void setMembershipId(String membershipId) {
        if (this.membershipId == null) {
            this.membershipId = membershipId;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return this.premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = answer; 
    }

    public static void main(String[] args) {
        System.out.println("--- Testing LibraryMemberBean ---");
        LibraryMemberBean bean = new LibraryMemberBean("Alice");
        bean.setMembershipId("M-1001");
        bean.setPremiumMember(true);
        bean.setSecurityAnswer("Fluffy");
        System.out.println("Member ID: " + bean.getMembershipId());
        System.out.println("Name: " + bean.getName());
        System.out.println("Is Premium: " + bean.isPremiumMember());
        // Demonstrating write-once membershipId behavior
        bean.setMembershipId("M-9999");
        System.out.println("Member ID after second set: " + bean.getMembershipId());
    }
}
