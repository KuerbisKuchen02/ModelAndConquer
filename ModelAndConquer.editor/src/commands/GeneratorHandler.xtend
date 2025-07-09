package commands

import ModelAndConquer.DamageType
import ModelAndConquer.Game
import ModelAndConquer.presentation.ModelAndConquerEditor
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.EList
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.ui.IFileEditorInput
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.handlers.HandlerUtil

class GeneratorHandler extends AbstractHandler {
	
	override execute(ExecutionEvent event) throws ExecutionException {
		println("Generator starting...");
		
		// Get active part of the model eclipse instance
		val IWorkbenchPart wbp = HandlerUtil.getActivePart(event);
		
		// Cast to project editor
		var ModelAndConquerEditor ue = wbp as ModelAndConquerEditor;
			
		// Get active project in the model eclipse instance
		var IProject project = (ue.getEditorInput() as IFileEditorInput).file.project;
		
		// Get selected element
		var TreeSelection ts = ue.selection as TreeSelection;
		
		var Game game = ts.firstElement as Game;		
		
		createFileWithContent(project, "models.generated", "Game.java", generateGame(game));
		
		// Generate all EDamageTypes
		createFileWithContent(project, "models.generated", "EDamageType.java", generateEDamageTypes(game.damageTypes));
		
		return void
	}
	
	def generateGame(Game game)'''
	public class Game {
		
	}
	'''
	
	def generateEDamageTypes(EList<DamageType> damageTypes) '''
	public enum EDamageType {
		«FOR int i: 0..damageTypes.size-1 SEPARATOR ','»
		«damageTypes.get(i).name.toUpperCase»(«i»)«IF i==damageTypes.size-1»;«ENDIF»
		«ENDFOR»
		
		private final int value;
		
		EDamageType(int value) { this.value=value; }
		
		public static String getValueString(int value) {
			return switch (value) {
				«FOR int i: 0..damageTypes.size-1»
				case «i» -> "«damageTypes.get(i).name»"
				«ENDFOR»
				default -> "Not an valid DamageType!"
			}
		}
	}
	'''
	
	
	def void createFileWithContent(IProject project, String pckgName, String fileName, CharSequence content) {
		var String currentFolderString = "src-gen/";
		var IFolder folder
		
		folder = project.getFolder("src-gen");
		if(!folder.exists) {
			folder.create(true, true, null)
		}
	
		for(String n : pckgName.split("\\.")) { //de . thm . zdh . Toll
			currentFolderString = currentFolderString + n + "/";
			folder = project.getFolder(currentFolderString);
			
			if(!folder.exists) {
				folder.create(true,true,null);
			}
		}

		var IFile file = folder.getFile(fileName);
	
		if(file.exists) {
			file.delete(true,null);
		}
	
		if(!file.exists) {
			var byte[] bytes;
			bytes = content.toString.bytes;
			var InputStream source = new ByteArrayInputStream(bytes);
			file.create(source, true, null);
		}
	}

}
