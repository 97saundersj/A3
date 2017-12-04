/**
 * stores an address.
 * @author 913613
 */
public class Address
{
    private String addressLine1;
    private String addressLine2;
    private String townOrCity;
    private String postCode;

    /**
     * 
     * @param addressLine1 the first line of the address
     * @param addressLine2 the second line of the address
     * @param townOrCity the town Or City of the address
     * @param postCode the postCode of the address
     */
    public Address(String addressLine1, String addressLine2, String townOrCity, String postCode)
    {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townOrCity = townOrCity;
        this.postCode = postCode;
    }
    /**
     * @return the first line of the address
     */
    public String getAddressLine1()
    {
        return addressLine1;
    }

    /**
     * @param addressLine1 the the first line of the address to set
     */
    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the second line of the address
     */
    public String getAddressLine2()
    {
        return addressLine2;
    }

    /**
     * @param addressLine2 the the second line of the address to set
     */
    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the town Or City of the address
     */
    public String getTownOrCity()
    {
        return townOrCity;
    }

    /**
     * @param townOrCity the town Or City of the address to set
     */
    public void setTownOrCity(String townOrCity)
    {
        this.townOrCity = townOrCity;
    }

    /**
     * @return the postCode of the address
     */
    public String getPostCode()
    {
        return postCode;
    }

    /**
     * @param postCode the postCode of the address to set
     */
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    
    /**
     * 
     * @return details about the Address class in string format
     */
    @Override
    public String toString()
    {
        String returnString = addressLine1 + " " + addressLine2 + " " + townOrCity 
                + " " + postCode;
        
        return returnString;
    }
}
