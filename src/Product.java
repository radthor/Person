import java.util.Calendar;

public class Product {



        private String ID;
        private String name;
        private String description;
        private double cost;


        public Product(String ID, String name, String description, double cost){
            this.ID = ID;
            this.name = name;
            this.description = description;
            this.cost = cost;
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString() {
            return "Product{" +
                    "ID='" + ID + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", cost='" + cost + '\'' +
                    '}';
        }
        public String toCSV() {
            return ID + ", " + name + ", " + description + ", " + cost;
        }

        public String toJSONRecord()
        {
            String retString = "";
            char DQ = '\u0022';  // Assign the double quote char to a variable
            retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.ID + DQ + ",";
            retString += DQ + "name" + DQ + ":" + DQ + this.name + DQ + ",";
            retString += " " + DQ + "description"  + DQ + ":" + DQ + this.description + DQ + ",";
            retString += " " + DQ + "cost" + DQ + ":" + DQ + this.cost + DQ + ",";

            return retString;
        }

        public String toXMLRecord()
        {
            String retString = "";

            retString = "<Product>" + "<IDNum>" + this.ID + "</IDNum>";
            retString += "<name>" + this.name + "</name>";
            retString += "<description>" + this.description + "</description>";
            retString += "<cost>" + this.cost + "</cost></Product>";

            return retString;
        }
}
