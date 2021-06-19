package helper;

public class ObjectsBank {
    public Name []names = {
            /*1*/ new Name("ahmad","mohammad", "sheik"),
            /*2*/ new Name("ali", "mahmud", "kasa"),
            /*3*/ new Name("alisar", "ali", "muhammad"),
            /*4*/ new Name("abd alrahman", "ziad" , "nakawa"),
            /*5*/ new Name("mohammed" , "adnan", "mamo"),
            /*6*/ new Name("abd alkarim", "khaled", "halawik"),
            /*7*/ new Name("amjad", "eaad", "morhash"),
            /*8*/ new Name("maya", "hassan", "alkenani"),
            /*9*/ new Name("hussain" , "hassn", "roumani"),
            /*10*/new Name("kenan", "ahmad", "alsaleh"),
            /*11*/new Name("hadi" , "hasan", "kaotsh"),
            /*12*/new Name("ammar" , "tahsin", "alzen"),
            /*13*/new Name("ziad", "baker", "alhalak"),
            /*14*/new Name("aya", "mutafa", "alsaid"),
            /*15*/new Name("zina", "ali", "alrawas")
    };
    public Address []addresses = {
            /*1*/ new Address("syria", "damascus"),
            /*2*/ new Address("lebanon", "beirut"),
            /*3*/ new Address("syria", "aleppo"),
            /*4*/ new Address("syria", "daraa"),
            /*5*/ new Address("canada", "toronto"),
            /*6*/ new Address("syria", "homs"),
            /*7*/ new Address("syria", "damascus"),
            /*8*/ new Address("lebanon", "beirut"),
            /*9*/ new Address("syria", "aleppo"),
            /*10*/new Address("syria", "daraa"),
            /*11*/new Address("canada", "toronto"),
            /*12*/new Address("syria", "homs"),
            /*13*/new Address("syria", "damascus"),
            /*14*/new Address("syria", "damascus"),
            /*15*/new Address("lebanon", "beirut"),
    };
    public Gender []genders = {
            /*1*/Gender.male,
            /*2*/Gender.male,
            /*3*/Gender.female,
            /*4*/Gender.male,
            /*5*/Gender.male,
            /*6*/Gender.male,
            /*7*/Gender.male,
            /*8*/Gender.female,
            /*9*/Gender.male,
            /*10*/Gender.male,
            /*11*/Gender.male,
            /*12*/Gender.male,
            /*13*/Gender.male,
            /*14*/Gender.female,
            /*15*/Gender.female,
    };

    public PerthDate []perthDates = {
            /*1*/ new PerthDate(2000, 1, 11),
            /*2*/ new PerthDate(2000, 2 ,22),
            /*3*/ new PerthDate(1999, 9, 9),
            /*4*/ new PerthDate(2001, 7, 30),
            /*5*/ new PerthDate(2002, 6, 12),
            /*6*/ new PerthDate(1980, 5, 2),
            /*7*/ new PerthDate(1983, 3, 13),
            /*8*/ new PerthDate(1990, 8, 24),
            /*9*/ new PerthDate(1985, 12, 11),
            /*10*/new PerthDate(1987, 10, 14),
            /*11*/new PerthDate(1992, 11, 26),
            /*12*/new PerthDate(1993, 4, 29),
            /*13*/new PerthDate(1987, 3 ,1),
            /*14*/new PerthDate(1975, 7,23),
            /*15*/new PerthDate(2000, 9, 18)
    };

    // student things
    public String []universities = {
            /*1*/ "SPU",
            /*2*/ "IUST",
            /*3*/ "SPU",
            /*4*/ "damascus university",
            /*5*/ "SPU"
    };
    public String []colleges = {
            /*1*/ "IT",
            /*2*/ "IT",
            /*3*/ "IT",
            /*4*/ "IT",
            /*5*/ "IT",
    };
    public String []studentSpecializations = {
            /*1*/"SI",
            /*2*/"AI",
            /*3*/"CC",
            /*4*/"CN",
            /*5*/"SI"
    };
    public float []gpas = {
            /*1*/ (float) 2.4,
            /*2*/ (float) 2.7,
            /*3*/ (float) 3.0,
            /*4*/ (float) 2.0,
            /*5*/ (float) 2.3
    };

    // doctors things
    public String []doctorSpecialization = {
            /*1*/"math",
            /*2*/"physic",
            /*3*/"IT",
            /*4*/"economy",
            /*5*/"IT"
    };
    public float []doctorsSalaries = {
            /*1*/2000,
            /*2*/1700,
            /*3*/3000,
            /*4*/1300,
            /*5*/2300
    };

    public String [][]courses = {
            /*1*/{"math"},
            /*2*/{"physic", "quantum theory"},
            /*3*/{},
            /*4*/{"algebra"},
            /*5*/{"matrix"}
    };

    // employees things
    public String []jobTitle = {
            /*1*/"HR",
            /*2*/"FT",
            /*3*/"SEO",
            /*4*/"STO",
            /*5*/"FT"
    };
    public float []employeesSalaries = {
            /*1*/1200,
            /*2*/1500,
            /*3*/7000,
            /*4*/5000,
            /*5*/1300
    };
}
