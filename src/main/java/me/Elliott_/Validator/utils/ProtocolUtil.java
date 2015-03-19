package me.Elliott_.Validator.utils;


import me.Elliott_.Validator.types.PGMProtocols;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProtocolUtil {

    public static String getCurrentMapProto() throws Exception {

        URL url = new URL("https://docs.oc.tc/modules/main");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        int i = 0;
        int isMapProtoLine = 0;
        while ((inputLine = in.readLine()) != null) {
            i++;
            if (inputLine.equals("Current map proto is")) {
                isMapProtoLine = i + 1;
            }

            if (i == isMapProtoLine) {
                return inputLine.replace("<strong>", "").replace("</strong>", "");
            }
        }

        in.close();
        return "null";
    }

    public static boolean validateProto(String proto) {
       return RegexUtil.validateRegex(proto, PGMProtocols.getRegex());
    }

}
