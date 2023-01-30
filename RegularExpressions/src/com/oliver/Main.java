package com.oliver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));
        System.out.println(alphanumeric.matches("^abcDeee"));

        System.out.println(alphanumeric.replaceAll("ijkl99z", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";

        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I have blanks and\ta tab, and also a new line\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\S", ""));

        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));

        String thirdAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>my headig</h1>");
        htmlText.append("<h2>sub headig</h2>");
        htmlText.append("<p>paragraph</p>");
        htmlText.append("<p>paragraph 2</p>");
        htmlText.append("<h2>summary</h2>");
        htmlText.append("<p>paragraph summary</p>");

//        String h2Pattern = ".*<h2>.*";
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
//        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("ocurrence " + count + ": " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPatern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPatern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("ocurrence " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPatern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPatern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("ocurrence " + h2TextMatcher.group(2));
        }

        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
    }
}