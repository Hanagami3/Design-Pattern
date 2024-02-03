package be.hanagami.builder;

import java.util.ArrayList;
import java.util.Collections;

class HtmlElement {
    public String name1, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name1, String text) {
        this.name1 = name1;
        this.text = text;
    }

    private String toStringImpl(int indent)
    {
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", i, name1, newLine));
        if (text != null && !text.isEmpty())
        {
            sb.append(String.join("", Collections.nCopies(indentSize*(indent+1), "")))
                    .append(text)
                    .append(newLine);
        }
        for (HtmlElement e :elements) sb.append(e.toStringImpl(indent + 1));

        sb.append(String.format("%s<%s>%s", i, name1, newLine));
        return sb.toString();
    }

    @Override
    public String toString()
    {
        return toStringImpl(0);
    }
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name1 = rootName;
    }

    public void addChild(String childName, String childText)
    {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }

    public HtmlBuilder addChildFluent(String chilName, String childText)
    {
        HtmlElement e = new HtmlElement(chilName, childText);
        root.elements.add(e);
        return this;
    }

    public void clear() {
        root = new HtmlElement();
        root.name1 = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

class Demo {
    public static void main(String[] args)
    {

//        String hello = "hello";
//        System.out.println("<p>" + hello + "</p>");
//
//        String [] words = {"hello", "world"};
//        System.out.println(
//                "<ul>\n" + "<li>" + words[0]
//        );
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("<ul>\n");
//        for (String word : words)
//        {
//            sb.append(String.format("  <li>%s</li>\n", word));
//        }
//        sb.append("</ul>");
//        System.out.println(sb);

        //we want to build a simple HTML paragraph
        System.out.println("Testing");
        String hello = "hello";
        StringBuilder sb = new StringBuilder();
        sb.append("<p>")
                .append("hello")
                .append("</p>"); // a builder
        System.out.println(sb);

        //now we want to build a list with 2 words
        String[] words = {"hello", "world"};
        sb.setLength(0); //clear it
        sb.append("<ul>\n");
        for (String word : words)
        {
            //indentation management, line break and other evils
            sb.append(String.format(" <li>%s</li>\n", word));
        }
        sb.append("</ul>");
        System.out.println(sb);

        // ordinary non-fluent builder
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
        System.out.println(builder);

        // fluent builder
        builder.clear();
        builder.addChildFluent("li", "hello")
                .addChildFluent("li", "world");
        System.out.println(builder);
    }
}