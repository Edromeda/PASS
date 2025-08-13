/**
 * Sticky Note Pad library class for KIT107 Lab 3.
 *
 * @author Julian Dermoudy and <<INSERT NAME HERE>>
 * @version 17/3/2025
 */

public class StickyNotePad
{
    private String[] pad;  // array of strings for note pad
    private int currentIndex; // index of current (displayed) note
    private int currentSize; // number of elements in use
    
    /**
     * Constructor
     * Instantiates array, and initialises current index and current
     *   usage count to 0
     * @param size number of elements in array
     */
    public StickyNotePad(int size)
    {
        // instantiate array
        pad = new String[size];

        // initialise other instance variables to zero
        currentIndex = 0;
        currentSize = 0;
 
    }
    
    /**
     * isFull
     * Check whether note pad is currently full, returning true if
     * so and false otherwise
     * @return boolean of whether note pad is full.
     */
    public boolean isFull()
    {
        return (currentSize>=pad.length);
    }
    
    /**
     * isEmpty
     * Check whether note pad is currently empty, returning true
     * if so and false otherwise
     * @return boolean of whether note pad is empty.
     */
    public boolean isEmpty()
    {
        return (currentIndex==0);
    }
    
    /**
     * addNote
     * Create a new note by moving to the end of the used portion
     *   of the array, expanding the used portion by incrementing
     *   currentSize, and adding the given String to the new last
     *   element.  If the array is full then nothing should be done.
     * @param n contents of new note
     */
    public void addNote(String n)
    {
        // if note pad isn't full...
        if (! isFull()) {
            // move current index to new last note
            currentIndex =currentSize;
            // increment size of used portion of array
            currentSize++;
            // store n in current element of note pad
            pad[currentIndex] = n;}
     }
    
    /**
     * deleteNote
     * Delete current note, moving all later notes down in the
     *   array to overwrite the current one.  If there are no
     *   notes then don't do anything.
     */
    public void deleteNote()
    {
        // if the note pad isn't empty...
        if(! isEmpty()){
            // use a for loop to overwrite elements from current element up with the one after
            for (int i =currentIndex; i<currentSize-1; i++)
            {
                pad[i] = pad[i+1];
            }
            // decrement count of used portion of array
            currentSize--;
            // if note pad is now empty then reset currentIndex to 0
            if (isEmpty())
            {
                currentIndex = 0;
            }
            else
            {
                // otherwise if currentIndex is beyond the used portion, make it the index of the last note
                if (currentIndex >= currentSize){
                    currentIndex = currentSize - 1;
                }
            }
    }
}
    
    /**
     * getNote
     * Examine current sticky note and return its contents
     *   prefaced by "NOTE x OF y.".  If there are no notes in
     *   the note pad then "" is returned.
     * @return String printable version of sticky note contents
     */
    public String getNote()
    {
        String ans;
        
        // is the sticky note pad empty?
        if (isFull()){
            // yes: answer is ""
            ans = "";
        }
            // no: answer is "NOTE x OF y.\n\n" plus contents of current note
            else{
                ans = "NOTE" + currentIndex + "OF" + currentSize + ".\n\n" + pad[currentIndex];
            }
    
        // return answer
        return ans;
    }
    
    /**
     * nextNote
     * Move current note index to next note in note pad (stopping
     *   at last note).
     */
    public void nextNote()
    {
        // increment current note index
        currentIndex++;
        // readjust current index to end of used portion if necessary
        if (currentIndex >= currentSize){
            currentIndex = currentSize - 1;
        }
    }
    
    /**
     * previousNote
     * Move current note index to previous note in note pad (stopping
     *   at first note).
     */
    public void previousNote()
    {
        // decrement current note index
        currentIndex--;
        // readjust current index to start of used portion if necessary
        if (currentIndex < 0)
        {
            currentIndex=0;
        }
    }
}
