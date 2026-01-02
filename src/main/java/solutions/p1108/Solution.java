package solutions.p1108;

public class Solution {

    public String defangIPaddr(String address) {

        if( address == null) return address;
        return address.replace(".", "[.]");
    }
}
