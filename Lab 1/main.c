#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int option, value, start, end, len;
char line[150], tempLine[20], saveLine[150];
char fileName[20], fileName2[20];
char num[20];
char temp;

struct node
{
    int data;
    struct node *next;
};
struct node *head;

struct doublyNode
{
    int doublyData;
    struct doublyNode *doublyNext;
    struct doublyNode *doublyPrev;
};
struct doublyNode *doublyHead;

void appendValue();
void append();
void prepend();
void prependValue();
void reverse();
void insertNode();
void deleteHead();
void deleteTail();
void deleteNode();
void displayList();
void searchNode();
void addList();
void deleteNodes();
int length();
void sortAsc();
void insertValue();
void saveChanges();
void appendDoubly();
void backwardsPrint();
void deleteAllDoublyNodes();

int main()
{
    option = 1;
    while (option != 3 ) {
        deleteNodes();
        printf("\n");
        printf("\n==========");
        printf("\nMain Menu: ");
        printf("\n==========\n");
        printf("\n1. Input the Linked List from keyboard, and store it in a file\n2. Load the Linked List from text file\n3. Exit the program\n");
        printf("\nEnter a number corresponding to an option from the list: ");
        scanf("%d", &option);
        switch (option)
        {
        case 1:
            printf("\nType 'e' if you want the Linked List to be empty.\nEnter the values for Linked List in one line, divided by an empty space: ");
            scanf("\n%[^\n]", line);
            printf("Enter the name for the file which will be created (.txt will be appended automatically): ");
            scanf("\n%[^\n]", fileName);
            strcat(fileName, ".txt");
            if (line[0] == 'e' && strlen(line) == 1)
            {
                FILE *fpointer = fopen(fileName, "w");
                fclose(fpointer);
            }
            else
            {
                if (line[0] == ' ')
                {
                    printf("\nInput can't start with an empty space. Please enter a valid input!");
                    break;
                }

                for (int i = 0; i < strlen(line); i++)
                {
                    if (line[i] == ' ')
                    {
                        int subLen;
                        subLen = end - start + 1;
                        memset(num, '\0', sizeof(num));
                        for (int k = 0; k < subLen; k++)
                        {
                            num[k] = line[start + k];
                        }
                        value = atoi(num);
                        appendValue(value);
                    }
                    else if (line[i] == '0' || line[i] == '1' || line[i] == '2' || line[i] == '3' || line[i] == '4' || line[i] == '5' || line[i] == '6' || line[i] == '7' || line[i] == '8' || line[i] == '9')
                    {
                        if (i == strlen(line) - 1)
                        {
                            end = strlen(line) - 1;
                            if (line[i - 1] == ' ')
                            {
                                start = i;
                            }
                            int subLen;
                            subLen = end - start + 1;
                            memset(num, '\0', sizeof(num));
                            for (int k = 0; k < subLen; k++)
                            {
                                num[k] = line[start + k];
                            }
                            value = atoi(num);
                            appendValue(value);
                            memset(num, '\0', sizeof(num));
                        }
                        else
                        {
                            if (i == 0 || line[i - 1] == ' ')
                            {
                                start = i;
                                end = i;
                            }
                            if (line[i + 1] == ' ')
                            {
                                end = i;
                            }
                        }
                        FILE *fpointer = fopen(fileName, "w");
                        fprintf(fpointer, "%s", line);
                        fclose(fpointer);
                    }
                    else
                    {
                        printf("\nPlease enter a valid input!");
                        break;
                    }
                }
                displayList();
            }
            break;
        case 2:
            printf("Enter the name for the file to be opened ('.txt' must be included): ");
            scanf("\n%[^\n]", fileName);
            FILE *fpointer = fopen(fileName, "r");
            fgets(line, 150, fpointer);
            fclose(fpointer);
            if (strlen(line) == 0)
            {
                break;
            }
            for (int i = 0; i < strlen(line); i++)
            {
                if (line[i] == ' ')
                {
                    int subLen;
                    subLen = end - start + 1;
                    memset(num, '\0', sizeof(num));
                    for (int k = 0; k < subLen; k++)
                    {
                        num[k] = line[start + k];
                    }
                    value = atoi(num);
                    appendValue(value);
                }
                else if (line[i] == '0' || line[i] == '1' || line[i] == '2' || line[i] == '3' || line[i] == '4' || line[i] == '5' || line[i] == '6' || line[i] == '7' || line[i] == '8' || line[i] == '9')
                {
                    if (i == strlen(line) - 1)
                    {
                        end = strlen(line) - 1;
                        if (line[i - 1] == ' ')
                        {
                            start = i;
                        }
                        int subLen;
                        subLen = end - start + 1;
                        memset(num, '\0', sizeof(num));
                        for (int k = 0; k < subLen; k++)
                        {
                            num[k] = line[start + k];
                        }
                        value = atoi(num);
                        appendValue(value);
                        memset(num, '\0', sizeof(num));
                    }
                    else
                    {
                        if (i == 0 || line[i - 1] == ' ')
                        {
                            start = i;
                            end = i;
                        }
                        if (line[i + 1] == ' ')
                        {
                            end = i;
                        }
                    }
                }
                else
                {
                    printf("\nPlease enter a valid input!");
                    break;
                }
            }
            displayList();
            break;
        case 3:
            exit(0);
            break;
        default:
            printf("\nPlease enter a valid input");
        }
        int choice = 1;
        while (choice != 15)
        {
            printf("\n");
            printf("\n===================");
            printf("\nThe list of options: ");
            printf("\n===================\n");
            printf("\n1. Append\n2. Prepend\n3. Reverse\n4. Add a value to a specific index\n5. Display the length of Linked List\n6. Delete HEAD\n7. Delete TAIL\n8. Delete a value from a specific index\n9. Sort the list\n10. Search for a value\n11. Merge with another Linked List\n12. Backward traversal\n13. Display the list\n14. Save changes\n15. Return to main menu\n");
            printf("\nEnter a number corresponding to an option from the list: ");
            scanf("%d", &choice);
            switch (choice)
            {
            case 1:
                append();
                break;
            case 2:
                prepend();
                break;
            case 3:
                reverse();
                break;
            case 4:
                insertNode();
                break;
            case 5:
                len = length();
                printf("\nLength of Linked List: %d\n", len);
                break;
            case 6:
                deleteHead();
                break;
            case 7:
                deleteTail();
                break;
            case 8:
                deleteNode();
                break;
            case 9:
                sortAsc();
                break;
            case 10:
                searchNode();
                break;
            case 11:
                addList();
                break;
            case 12:
                if (strlen(line) == 0)
                {
                    printf("Linked List is empty");
                    break;
                }
                memset(line, '\0', sizeof(line));
                struct node *ptr;
                ptr = head;
                while (ptr != NULL)
                {
                sprintf(tempLine, "%d", ptr->data);
                strcat(line, tempLine);
                strcat(line, " ");
                ptr = ptr->next;
                }   
                for (int i = 0; i < strlen(line); i++)
                {
                    if (line[i] == ' ')
                    {
                        int subLen;
                        subLen = end - start + 1;
                        memset(num, '\0', sizeof(num));
                        for (int k = 0; k < subLen; k++)
                        {
                            num[k] = line[start + k];
                        }
                        value = atoi(num);
                        appendDoubly(value);
                    }
                    else if (line[i] == '0' || line[i] == '1' || line[i] == '2' || line[i] == '3' || line[i] == '4' || line[i] == '5' || line[i] == '6' || line[i] == '7' || line[i] == '8' || line[i] == '9')
                    {
                        if (i == strlen(line) - 1)
                        {
                            end = strlen(line) - 1;
                            if (line[i - 1] == ' ')
                            {
                                start = i;
                            }
                            int subLen;
                            subLen = end - start + 1;
                            memset(num, '\0', sizeof(num));
                            for (int k = 0; k < subLen; k++)
                            {
                                num[k] = line[start + k];
                            }
                            value = atoi(num);
                            appendDoubly(value);
                            memset(num, '\0', sizeof(num));
                        }
                        else
                        {
                            if (i == 0 || line[i - 1] == ' ')
                            {
                                start = i;
                                end = i;
                            }
                            if (line[i + 1] == ' ')
                            {
                                end = i;
                            }
                        }
                    }
                    else
                    {
                        break;
                    }
                }
                printf("\nBackward traversal using Doubly Linked List: ");
                backwardsPrint();
                deleteAllDoublyNodes();
                break;
            case 13:
                displayList();
                break;
            case 14:
                saveChanges(fileName);
                break;
            case 15:
                break;
            default:
                printf("No such option. Please enter a valid choice!");
            }
        }
    }
    return 0;
}

// Main Linked List functions:
void appendValue(int item)
{
    struct node *ptr, *temp;
    ptr = (struct node *)malloc(sizeof(struct node));
    if (ptr == NULL)
    {
        printf("\nOVERFLOW ERROR");
    }
    else
    {
        ptr->data = item;
        if (head == NULL)
        {
            ptr->next = NULL;
            head = ptr;
        }
        else
        {
            temp = head;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = ptr;
            ptr->next = NULL;
        }
    }
}
void append()
{
    struct node *ptr, *temp;
    int item;
    ptr = (struct node *)malloc(sizeof(struct node));
    if (ptr == NULL)
    {
        printf("\nOVERFLOW ERROR");
    }
    else
    {
        printf("\nEnter the value: ");
        scanf("%d", &item);
        ptr->data = item;
        if (head == NULL)
        {
            ptr->next = NULL;
            head = ptr;
        }
        else
        {
            temp = head;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = ptr;
            ptr->next = NULL;
        }
    }
}
void prepend()
{
    struct node *ptr;
    int item;
    ptr = (struct node *)malloc(sizeof(struct node *));
    if (ptr == NULL)
    {
        printf("\nOVERFLOW ERROR");
    }
    else
    {
        printf("\nEnter the value: ");
        scanf("%d", &item);
        ptr->data = item;
        ptr->next = head;
        head = ptr;
    }
}
void prependValue(int item)
{
    struct node *ptr;
    ptr = (struct node *)malloc(sizeof(struct node *));
    if (ptr == NULL)
    {
        printf("\nOVERFLOW ERROR");
    }
    else
    {
        ptr->data = item;
        ptr->next = head;
        head = ptr;
    }
}
void reverse()
{
    struct node *current, *prev, *next;
    current = head;
    prev = NULL;
    while (current != NULL)
    {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    head = prev;
}
void insertNode()
{
    struct node *temp, *newnode;
    int pos, data, i = 1;
    newnode = malloc(sizeof(struct node));
    printf("\nEnter position at which you want to add the node: ");
    scanf("%d", &pos);
    int len;
    len = length();
    if (len < pos)
    {
        printf("The indicated position is bigger than the length of the list.\nPlease enter an index smaller or equal to %d\n", len);
    }
    else
    {
        printf("\nEnter the value: ");
        scanf("%d", &data);
        if (pos == 0)
        {
            prepend();
        }
        else
        {
            temp = head;
            newnode->data = data;
            newnode->next = 0;
            while (i < pos)
            {
                temp = temp->next;
                i++;
            }
            newnode->next = temp->next;
            temp->next = newnode;
        }
    }
}
void insertValue(int pos, int data)
{
    struct node *temp, *newnode;
    int i = 1;
    newnode = malloc(sizeof(struct node));
    int len;
    len = length();
    if (pos == 0)
    {
        prependValue(data);
    }
    else
    {
        temp = head;
        newnode->data = data;
        newnode->next = 0;
        while (i < pos)
        {
            temp = temp->next;
            i++;
        }
        newnode->next = temp->next;
        temp->next = newnode;
    }
}
void deleteHead()
{
    struct node *ptr;
    if (head == NULL)
    {
        printf("\nList is empty\n");
    }
    else
    {
        ptr = head;
        head = ptr->next;
        free(ptr);
    }
}
void deleteTail()
{
    struct node *ptr, *ptr1;
    if (head == NULL)
    {
        printf("\nList is empty");
    }
    else if (head->next == NULL)
    {
        head = NULL;
        free(head);
    }
    else
    {
        ptr = head;
        while (ptr->next != NULL)
        {
            ptr1 = ptr;
            ptr = ptr->next;
        }
        ptr1->next = NULL;
        free(ptr);
    }
}
void deleteNode()
{
    struct node *temp, *position;
    int i = 1, pos;
    if (head == NULL)
        printf("\nList is empty\n");
    else
    {
        printf("\nEnter index : ");
        scanf("%d", &pos);
        if (pos == 0)
        {
            deleteHead();
        }
        else
        {
            int len;
            len = length();
            if (len <= pos)
            {
                printf("The indicated position is bigger or equal to the length of the list.\nPlease enter an index smaller than %d\n", len);
            }
            else
            {
                position = malloc(sizeof(struct node));
                temp = head;
                while (i < pos - 1)
                {
                    temp = temp->next;
                    i++;
                }
                position = temp->next;
                temp->next = position->next;
                free(position);
            }
        }
    }
}
void searchNode()
{
    struct node *ptr;
    int item, i = 0, flag = 0;
    ptr = head;
    if (ptr == NULL)
    {
        printf("\nList is empty\n");
    }
    else
    {
        printf("\nEnter the value you want to be searched: ");
        scanf("%d", &item);
        while (ptr != NULL)
        {
            if (ptr->data == item)
            {
                printf("\nValue found at index: %d ", i);
                flag = 1;
            }
            i++;
            ptr = ptr->next;
        }
        if (flag == 0)
        {
            printf("Value not found\n");
        }
    }
}
void deleteNodes()
{
    struct node *current;
    current = head;
    struct node *next = NULL;
    while (current != NULL)
    {
        next = current->next;
        free(current);
        current = next;
    }
    head = NULL;
}
void addList()
{
    printf("\nThe new list will be: \n1. Appended\n2. Prepended\n");
    printf("\nEnter a number corresponding to an option from the list: ");
    int choice, pos = 0;
    scanf("%d", &choice);
    printf("\nEnter the new list: ");
    printf("\n1. Input the Linked List from keyboard\n2. Load the Linked List from text file\n");
    printf("\nEnter a number corresponding to an option from the list: ");
    scanf("%d", &option);
    switch (option)
    {
    case 1:
        printf("\nEnter the values for Linked List in one line, divided by an empty space: ");
        scanf("\n%[^\n]", line);
        if (line[0] == ' ')
        {
            printf("Input can't start with an empty space. Please enter a valid input!");
            break;
        }
        for (int i = 0; i < strlen(line); i++)
        {
            if (line[i] == ' ')
            {
                int subLen;
                subLen = end - start + 1;
                memset(num, '\0', sizeof(num));
                for (int k = 0; k < subLen; k++)
                {
                    num[k] = line[start + k];
                }
                value = atoi(num);
                switch (choice)
                {
                case 1:
                    appendValue(value);
                    break;
                case 2:
                    insertValue(pos, value);
                    pos++;
                    break;
                default:
                    printf("Invalid input");
                    break;
                }
            }
            else if (line[i] == '0' || line[i] == '1' || line[i] == '2' || line[i] == '3' || line[i] == '4' || line[i] == '5' || line[i] == '6' || line[i] == '7' || line[i] == '8' || line[i] == '9')
            {
                if (i == strlen(line) - 1)
                {
                    end = strlen(line) - 1;
                    if (line[i - 1] == ' ')
                    {
                        start = i;
                    }
                    int subLen;
                    subLen = end - start + 1;
                    memset(num, '\0', sizeof(num));
                    for (int k = 0; k < subLen; k++)
                    {
                        num[k] = line[start + k];
                    }
                    value = atoi(num);
                    switch (choice)
                    {
                    case 1:
                        appendValue(value);
                        break;
                    case 2:
                        insertValue(pos, value);
                        pos++;
                        break;
                    default:
                        printf("Invalid input");
                        break;
                    }
                    memset(num, '\0', sizeof(num));
                }
                else
                {
                    if (i == 0 || line[i - 1] == ' ')
                    {
                        start = i;
                        end = i;
                    }
                    if (line[i + 1] == ' ')
                    {
                        end = i;
                    }
                }
            }
            else
            {
                printf("Please enter a valid input!\n");
                break;
            }
        }
        break;
    case 2:
        printf("Enter the name for the file to be opened ('.txt' must be included): ");
        scanf("\n%[^\n]", fileName2);
        FILE *fpointer2 = fopen(fileName2, "r");
        fgets(line, 150, fpointer2);
        fclose(fpointer2);
        if (strlen(line) == 0)
        {
            break;
        }
        for (int i = 0; i < strlen(line); i++)
        {
            if (line[i] == ' ')
            {
                int subLen;
                subLen = end - start + 1;
                memset(num, '\0', sizeof(num));
                for (int k = 0; k < subLen; k++)
                {
                    num[k] = line[start + k];
                }
                value = atoi(num);
                switch (choice)
                {
                case 1:
                    appendValue(value);
                    break;
                case 2:
                    insertValue(pos, value);
                    pos++;
                    break;
                default:
                    printf("Invalid input");
                    break;
                }
            }
            else if (line[i] == '0' || line[i] == '1' || line[i] == '2' || line[i] == '3' || line[i] == '4' || line[i] == '5' || line[i] == '6' || line[i] == '7' || line[i] == '8' || line[i] == '9')
            {
                if (i == strlen(line) - 1)
                {
                    end = strlen(line) - 1;
                    if (line[i - 1] == ' ')
                    {
                        start = i;
                    }
                    int subLen;
                    subLen = end - start + 1;
                    memset(num, '\0', sizeof(num));
                    for (int k = 0; k < subLen; k++)
                    {
                        num[k] = line[start + k];
                    }
                    value = atoi(num);
                    switch (choice)
                    {
                    case 1:
                        appendValue(value);
                        break;
                    case 2:
                        insertValue(pos, value);
                        pos++;
                        break;
                    default:
                        printf("Invalid input");
                        break;
                    }
                    memset(num, '\0', sizeof(num));
                }
                else
                {
                    if (i == 0 || line[i - 1] == ' ')
                    {
                        start = i;
                        end = i;
                    }
                    if (line[i + 1] == ' ')
                    {
                        end = i;
                    }
                }
            }
            else
            {
                printf("Please enter a valid input!");
                break;
            }
        }
        break;
    default:
        printf("Please enter a valid input");
    }
}
void displayList()
{
    struct node *ptr;
    ptr = head;
    if (ptr == NULL)
    {
        printf("List is empty");
    }
    else
    {
        printf("\nLinked List values: \n");
        while (ptr != NULL)
        {
            printf("%d ", ptr->data);
            ptr = ptr->next;
        }
    }
}
int length()
{
    int count = 0;
    struct node *current = head;
    while (current != NULL)
    {
        count++;
        current = current->next;
    }
    return count;
}
void sortAsc()
{
    struct node *current = head;
    struct node *index = NULL;
    int temp;
    if (head == NULL)
    {
        printf("List is empty. Nothing to sort");
        return;
    }
    else
    {
        while (current != NULL)
        {
            index = current->next;
            while (index != NULL)
            {
                if (current->data > index->data)
                {
                    temp = current->data;
                    current->data = index->data;
                    index->data = temp;
                }
                index = index->next;
            }
            current = current->next;
        }
    }
}
void saveChanges(char *file)
{
    FILE *fpointer3 = fopen(file, "w");
    memset(line, '\0', sizeof(line));
    struct node *ptr;
    ptr = head;
    if (ptr == NULL)
    {
        fclose(fpointer3);
    }
    else
    {
        while (ptr != NULL)
        {
            sprintf(tempLine, "%d", ptr->data);
            strcat(line, tempLine);
            strcat(line, " ");
            ptr = ptr->next;
        }
        fprintf(fpointer3, "%s", line);
        fclose(fpointer3);
    }
}
// Doubly Linked List functions:
void appendDoubly(int item)
{
    struct doublyNode *ptr, *last;
    ptr = (struct doublyNode *)malloc(sizeof(struct doublyNode));
    last = doublyHead;
    ptr->doublyData = item;
    ptr->doublyNext = NULL;

    if (doublyHead == NULL)
    {
        ptr->doublyPrev = NULL;
        doublyHead = ptr;
        return;
    }
    while (last->doublyNext != NULL)
    {
        last = last->doublyNext;
    }
    last->doublyNext = ptr;
    ptr->doublyPrev = last;
    return;
}
void backwardsPrint()
{
    struct doublyNode *tail;
    tail = doublyHead;
    while (tail->doublyNext != NULL)
    {
        tail = tail->doublyNext;
    }
    while (tail != doublyHead)
    {
        printf("%d ", tail->doublyData);
        tail = tail->doublyPrev;
    }
    printf("%d\n", tail->doublyData);
}
void deleteAllDoublyNodes()
{
    struct doublyNode *temp;
    while (doublyHead != NULL)
    {
        temp = doublyHead;
        doublyHead = doublyHead->doublyNext;
        free(temp);
    }
}