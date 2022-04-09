import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

/**
 * 
 */

/**
 * @author 
 *
 */
class Junit {
	BinarySearchTree treeEnglish = new BinarySearchTree();
    association<String, String> palabra = new association<String, String>("house","casa"); 
    @Test
	public void testInsert() {
        treeEnglish.insert(palabra);
        String word = treeEnglish.translateKey("house");
        assertEquals(word,"casa");
	}
    @Test
	public void testSearch() {
        treeEnglish.insert(palabra);
        String word = treeEnglish.translateKey("house");
        assertEquals(word,"casa");
	}
}
