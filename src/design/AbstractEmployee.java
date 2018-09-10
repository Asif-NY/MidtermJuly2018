package design;



    public abstract class AbstractEmployee implements Employee {

        public final String founderName = "Asif";
        static String address = "31-10, 37th Avenue, Long Island City Astoria, NY";

        public void describeCompany() {
            System.out.println("In the year 2018 " + founderName + " founded the company located at " + address + ".");
        }
        public abstract void describeCompany(String Mission);
    }

