package markdown;

import com.vladsch.flexmark.ast.*;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

public class MarkdownUtils {

    private static final Parser parser = Parser.builder().build();

    public static void printMarkdownToConsole(String markdown) {
        if (markdown == null || markdown.isEmpty()) {
            System.out.println();
            return;
        }

        Node document = parser.parse(markdown);
        renderNode(document);
    }

    private static void renderNode(Node node) {
        Node current = node.getFirstChild();
        while (current != null) {
            if (current instanceof Heading) {
                printHeading((Heading) current);
            } else if (current instanceof Paragraph) {
                printParagraph((Paragraph) current);
            } else if (current instanceof BulletList) {
                printBulletList((BulletList) current);
            } else {
                System.out.print(current.getChars());
            }
            current = current.getNext();
        }
    }

    private static void printHeading(Heading heading) {
        String hashes = "#".repeat(heading.getLevel());
        System.out.println("\033[1m" + hashes + " " + heading.getText() + "\033[0m\n");
    }

    private static void printParagraph(Paragraph paragraph) {
        Node child = paragraph.getFirstChild();
        while (child != null) {
            if (child instanceof Text) {
                System.out.print(((Text) child).getChars());
            } else if (child instanceof StrongEmphasis) {
                System.out.print("\033[1m" + ((StrongEmphasis) child).getText() + "\033[0m");
            } else if (child instanceof Emphasis) {
                System.out.print("\033[3m" + ((Emphasis) child).getText() + "\033[0m");
            } else {
                System.out.print(child.getChars());
            }
            child = child.getNext();
        }
        System.out.println("\n");
    }

    private static void printBulletList(BulletList list) {
        for (Node item : list.getChildren()) {
            if (item instanceof BulletListItem) {
                System.out.print("  • ");
                printParagraph((Paragraph) item.getFirstChild());
            }
        }
    }

    public static void main(String[] args) {
        String markdown = """
            # Title
            This is a paragraph with **bold** and *italic* text.

            ## Subtitle
            Another paragraph.

            - First item
            - Second item
            """;

        printMarkdownToConsole(markdown);
    }
}
