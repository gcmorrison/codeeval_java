import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by campbell on 2016/01/19.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            main.printResult(line);
        }
    }

    void printResult(String line) {
        System.out.println(sumOfLabeledItemsIds(line));
    }

    public int sumOfLabeledItemsIds(String json) {
        if (json == null || json.length() == 0) {
            return 0;
        }

        int sum = 0;
        String[] items = extractItems(json);
        for (String item : items) {
            if (itemContainsLabel(item)) {
                sum += getItemId(item);
            }
        }

        return sum;
    }

    private String[] extractItems(String json) {
        if (!doesJsonContainItemsBlock(json)) {
            return new String[0];
        }

        String unparsedItems = getItemsContentBlock(json);

        int itemCount = countNumberOfItems(unparsedItems);
        String[] items = new String[itemCount];

        int itemIndex = 0;
        String item;
        while (unparsedItems.lastIndexOf("}") != -1) {
            item = getFirstItem(unparsedItems);
            unparsedItems = removeItemFromBlock(unparsedItems, item);
            items[itemIndex++] = item;
        }

        return items;
    }

    private boolean doesJsonContainItemsBlock(String json) {
        return json.contains(getItemStartBlock());
    }

    private String getItemStartBlock() {
        return "\"items\": [";
    }

    private String getItemsContentBlock(String json) {
        String itemBlockStart = getItemStartBlock();
        String itemBlockEnd = "]";

        int startIndex = json.indexOf(itemBlockStart);
        int endIndex = json.indexOf(itemBlockEnd, startIndex) + 1;

        return json.substring(startIndex, endIndex).replace(itemBlockStart, "").replace(itemBlockEnd, "");
    }

    private int countNumberOfItems(String unparsedItems) {
        Pattern itemPattern = Pattern.compile("\\{\\\"id\\\": [\\d]+[^\\}]*\\}");
        Matcher itemMatcher = itemPattern.matcher(unparsedItems);

        int count = 0;
        while (itemMatcher.find()) {
            count++;
        }

        return count;
    }

    private String getFirstItem(String unparsedItems) {
        return unparsedItems.substring(unparsedItems.indexOf("{"), unparsedItems.indexOf("}") + 1);
    }

    private String removeItemFromBlock(String unparsedItems, String item) {
        return unparsedItems.replace(item, "");
    }

    private boolean itemContainsLabel(String item) {
        return item.contains("label");
    }

    private int getItemId(String item) {
        return Integer.valueOf(item.replaceAll("label.*", "").replaceAll("[^\\d]", ""));
    }
}
