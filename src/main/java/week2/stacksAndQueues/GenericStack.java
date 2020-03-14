package week2.stacksAndQueues;

public interface GenericStack<Item> {
    void push(Item item);
    Item pop();
    boolean isEmpty();
    int size();
}
