package helper;

public class Name {
    public String fName;
    public String mName;
    public String lName;

    public Name(){}

    public Name(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }

    public void setName(){
        setFName();
        setMName();
        setLName();
    }

    public void setFName() {
        fName = Input.getString("enter first name: ", "wrong input! enter again");
    }

    public void setMName() {
        mName = Input.getString("enter  meddle name: ", "wrong input enter again");
    }

    public void setLName() {
        lName = Input.getString("enter  last name: ", "wrong input enter again");
    }
}
