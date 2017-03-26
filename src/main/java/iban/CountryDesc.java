package iban;

import java.util.List;

/**
 * Created by andrius on 23/03/2017.
 */
public enum CountryDesc {

    AL("Albania","AL",28,"8n,16c",""),
    AD("Andorra","AD",24,"8n,12c",""),
    AT("Austria","AT",20,"16n",""),
    AZ("Azerbaijan","AZ",28,"4c,20n",""),
    BH("Bahrain","BH",22,"4a,14c",""),
    BY("Belarus","BY",28,"4c, 20n",""),
    BE("Belgium","BE",16,"12n",""),
    BA("Bosnia and Herzegovina","BA",20,"16n",""),
    BR("Brazil","BR",29,"23n,1a,1c",""),
    BG("Bulgaria","BG",22,"4a,6n,8c",""),
    CR("Costa Rica","CR",22,"17n",""),
    HR("Croatia","HR",21,"17n",""),
    CY("Cyprus","CY",28,"8n,16c",""),
    CZ("Czech Republic","CZ",24,"20n",""),
    DK("Denmark","DK",18,"14n",""),
    DO("Dominican Republic","DO",28,"4a,20n",""),
    TL("East Timor","TL",23,"19n","38"),
    EE("Estonia","EE",20,"16n",""),
    FO("Faroe Islands","FO",18,"14n",""),
    FI("Finland","FI",18,"14n",""),
    FR("France","FR",27,"10n,11c,2n",""),
    GE("Georgia","GE",22,"2c,16n",""),
    DE("Germany","DE",22,"18n",""),
    GI("Gibraltar","GI",23,"4a,15c",""),
    GR("Greece","GR",27,"7n,16c",""),
    GL("Greenland","GL",18,"14n",""),
    GT("Guatemala","GT",28,"4c,20c",""),
    HU("Hungary","HU",28,"24n",""),
    IS("Iceland","IS",26,"22n",""),
    IE("Ireland","IE",22,"4c,14n",""),
    IL("Israel","IL",23,"19n",""),
    IT("Italy","IT",27,"1a,10n,12c",""),
    JO("Jordan","JO",30,"4a,22n",""),
    KZ("Kazakhstan","KZ",20,"3n,13c",""),
    XK("Kosovo","XK",20,"4n,10n,2n",""),
    KW("Kuwait","KW",30,"4a,22c",""),
    LV("Latvia","LV",21,"4a,13c",""),
    LB("Lebanon","LB",28,"4n,20c",""),
    LI("Liechtenstein","LI",21,"5n,12c",""),
    LT("Lithuania","LT",20,"16n",""),
    LU("Luxembourg","LU",20,"3n,13c",""),
    MK("Macedonia","MK",19,"3n,10c,2n","07"),
    MT("Malta","MT",31,"4a,5n,18c",""),
    MR("Mauritania","MR",27,"23n","13"),
    MU("Mauritius","MU",30,"4a,19n,3a",""),
    MC("Monaco","MC",27,"10n,11c,2n",""),
    MD("Moldova","MD",24,"2c,18c",""),
    ME("Montenegro","ME",22,"18n","25"),
    NL("Netherlands","NL",18,"4a,10n",""),
    NO("Norway","NO",15,"11n",""),
    PK("Pakistan","PK",24,"4c,16n",""),
    PS("Palestinian territories","PS",29,"4c,21n",""),
    PL("Poland","PL",28,"24n",""),
    PT("Portugal","PT",25,"21n","50"),
    QA("Qatar","QA",29,"4a,21c",""),
    RO("Romania","RO",24,"4a,16c",""),
    SM("San Marino","SM",27,"1a,10n,12c",""),
    SA("Saudi Arabia","SA",24,"2n,18c",""),
    RS("Serbia","RS",22,"18n",""),
    SK("Slovakia","SK",24,"20n",""),
    SI("Slovenia","SI",19,"15n","56"),
    ES("Spain","ES",24,"20n",""),
    SE("Sweden","SE",24,"20n",""),
    CH("Switzerland","CH",21,"5n,12c",""),
    TN("Tunisia","TN",24,"20n","59"),
    TR("Turkey","TR",26,"5n,17c",""),
    AE("United Arab Emirates","AE",23,"3n,16n",""),
    GB("United Kingdom","GB",22,"4a,14n",""),
    VG("Virgin Islands, British","VG",24,"4c,16n","");

    private final String name;
    private final String code;
    private final String bbanFormat;
    private final String checkDigistsAllways;
    private final int length;

    CountryDesc(String name, String code, int length, String bbanFormat, String checkDigistsAllways) {
        this.name = name;
        this.code = code;
        this.bbanFormat = bbanFormat;
        this.checkDigistsAllways = checkDigistsAllways;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getCode() {
        return code;
    }

    public String getCheckDigistsAllways() {
        return checkDigistsAllways;
    }

    public String getBbanFormat() {
        return bbanFormat;
    }

    public List getValues() {
        return this.getValues();
    }
}
