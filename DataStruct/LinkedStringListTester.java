
/**
 * A program that tests the class ContiguousStringList
 */

public class LinkedStringListTester {
    /**
     * main method: test the class ContiguousIntQueue
     */
    public static void main(String[] args) {
        LinkedStringList lsl = new LinkedStringList();

        // Empty list
        if (lsl.isEmpty()) {
            System.out.println("Currently, the list is empty.");
        } 
        else {
            System.out.println("The method isEmpty() does not return correct result.");
            System.exit(0);
        }

        if (!lsl.isFull()) {
            System.out.println("The list is not full.");
        } 
        else {
            System.out.println("The method isFull() does not return correct result.");
            System.exit(0);
        }

        if (lsl.size() == 0) {
            System.out.println("The length of the list is 0.");
        } 
        else {
            System.out.println("The method size() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // inserting "aaa" at 0
        System.out.println("Inserting string \"aaa\" at position 0 ...");
        try {
            lsl.insert("aaa", 0);
            System.out.println("String \"aaa\" inserted at position 0.");
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method insert() does not work properly.");
            System.exit(0);
        }

        if (!lsl.isEmpty()) {
            System.out.println("Currently, the list is not empty.");
        } 
        else {
            System.out.println("The method isEmpty() does not return correct result.");
            System.exit(0);
        }

        if (!lsl.isFull()) {
            System.out.println("The list is not full.");
        } 
        else {
            System.out.println("The method isFull() does not return correct result.");
            System.exit(0);
        }

        if (lsl.size() == 1) {
            System.out.println("The length of the list is 1.");
        } 
        else {
            System.out.println("The method size() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // inserting "ccc" at 1
        System.out.println("Inserting string \"ccc\" at position 1 ...");
        try {
            lsl.insert("ccc", 1);
            System.out.println("String \"ccc\" inserted at position 1.");
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method insert() does not work properly.");
            System.exit(0);
        }

        if (!lsl.isEmpty()) {
            System.out.println("Currently, the list is not empty.");
        } 
        else {
            System.out.println("The method isEmpty() does not return correct result.");
            System.exit(0);
        }

        if (!lsl.isFull()) {
            System.out.println("The list is not full.");
        } 
        else {
            System.out.println("The method isFull() does not return correct result.");
            System.exit(0);
        }

        if (lsl.size() == 2) {
            System.out.println("The length of the list is 2.");
        } 
        else {
            System.out.println("The method size() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // inserting "ddd" at 10
        System.out.println("Inserting string \"ddd\" at position 10 ...");
        try {
            lsl.insert("ddd", 10);
            System.out.println("The method insert() does not work properly.");
            System.exit(0);
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("String \"ddd\" cannot be inserted at position 10.");
        }

        if (!lsl.isEmpty()) {
            System.out.println("Currently, the list is not empty.");
        } 
        else {
            System.out.println("The method isEmpty() does not return correct result.");
            System.exit(0);
        }

        if (!lsl.isFull()) {
            System.out.println("The list is not full.");
        } 
        else {
            System.out.println("The method isFull() does not return correct result.");
            System.exit(0);
        }

        if (lsl.size() == 2) {
            System.out.println("The length of the list is 2.");
        } 
        else {
            System.out.println("The method size() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // inserting "bbb" at 1
        System.out.println("Inserting string \"bbb\" at position 1 ...");
        try {
            lsl.insert("bbb", 1);
            System.out.println("String \"bbb\" inserted at position 1.");
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method insert() does not work properly.");
            System.exit(0);
        }

        if (!lsl.isEmpty()) {
            System.out.println("Currently, the list is not empty.");
        } 
        else {
            System.out.println("The method isEmpty() does not return correct result.");
            System.exit(0);
        }

        if (!lsl.isFull()) {
            System.out.println("The list is not full.");
        } 
        else {
            System.out.println("The method isFull() does not return correct result.");
            System.exit(0);
        }

        if (lsl.size() == 3) {
            System.out.println("The length of the list is 3.");
        } 
        else {
            System.out.println("The method size() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // retrieving "aaa"
        System.out.println("Retrieving the string at position 0 ...");
        try {
            if (lsl.retrieve(0).equals("aaa")) {
                System.out.println("String \"aaa\" retrieved from position 0.");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method retrieve() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // retrieving "bbb"
        System.out.println("Retrieving the string at position 1 ...");
        try {
            if (lsl.retrieve(1).equals("bbb")) {
                System.out.println("String \"bbb\" retrieved from position 1.");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method retrieve() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // retrieving "ccc"
        System.out.println("Retrieving the string at position 2 ...");
        try {
            if (lsl.retrieve(2).equals("ccc")) {
                System.out.println("String \"ccc\" retrieved from position 2.");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method retrieve() does not return correct result.");
            System.exit(0);
        }
        System.out.println();

        // retrieving from position 10
        System.out.println("Retrieving the string at position 10 ...");
        try {
            lsl.retrieve(10);
            System.out.println("The method retrieve() does not work properly.");
            System.exit(0);
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("We cannot retrieve from position 10 since the list size is 3.");
        }
        System.out.println();

        // replacing "aaa" with "000"
        System.out.println("Replacing the string at position 0 with \"000\" ...");
        try {
            lsl.replace("000", 0);
            if (lsl.retrieve(0).equals("000")) {
                System.out.println("String \"000\" placed into position 0.");
            }
            else {
                System.out.println("The method replace() does not work properly.");
                System.exit(0);
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method replace() does not work properly.");
            System.exit(0);
        }
        System.out.println();

        // replacing at position 10
        System.out.println("Replacing the string at position 10 ...");
        try {
            lsl.replace("111", 10);
            System.out.println("The method replace() does not work properly.");
            System.exit(0);
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("We cannot replace the string at position 10 since the list size is 3.");
        }
        System.out.println();

        // removing "bbb" at position 1"
        System.out.println("Removing the string at position 1 ...");
        try {
            lsl.remove(1);
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method remove() does not work properly.");
            System.exit(0);
        }
        if (!lsl.isEmpty()) {
            System.out.println("Currently, the list is not empty.");
        } 
        else {
            System.out.println("The method isEmpty() does not return correct result.");
            System.exit(0);
        }

        if (!lsl.isFull()) {
            System.out.println("The list is not full.");
        } 
        else {
            System.out.println("The method isFull() does not return correct result.");
            System.exit(0);
        }

        if (lsl.size() == 2) {
            System.out.println("The length of the list is 2.");
        } 
        else {
            System.out.println("The method size() does not return correct result.");
            System.exit(0);
        }

        // retrieving "000"
        System.out.println("Retrieving the string at position 0 ...");
        try {
            if (lsl.retrieve(0).equals("000")) {
                System.out.println("String \"000\" retrieved from position 0.");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method remove() does not work properly.");
            System.exit(0);
        }

        // retrieving "ccc"
        System.out.println("Retrieving the string at position 1 ...");
        try {
            if (lsl.retrieve(1).equals("ccc")) {
                System.out.println("String \"ccc\" retrieved from position 1.");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The method remove() does not work properly.");
            System.exit(0);
        }
        System.out.println();

        // removing at position 10
        System.out.println("Removing the string at position 10 ...");
        try {
            lsl.remove(10);
            System.out.println("The method remove() does not work properly.");
            System.exit(0);
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("We cannot remove the string at position 10 since the list size is 2.");
        }
        System.out.println();

        // clearing the list
        System.out.println("Clearing the whole list ...");
        lsl.clear();
        if (lsl.isEmpty()) {
            System.out.println("Currently, the list is empty.");
        } 
        else {
            System.out.println("The method clear() does not work properly.");
            System.exit(0);
        }

        if (!lsl.isFull()) {
            System.out.println("The list is not full.");
        } 
        else {
            System.out.println("The method clear() does not work properly.");
            System.exit(0);
        }

        if (lsl.size() == 0) {
            System.out.println("The length of the list is 0.");
        } 
        else {
            System.out.println("The method clear() does not work properly.");
            System.exit(0);
        }
    }
}

