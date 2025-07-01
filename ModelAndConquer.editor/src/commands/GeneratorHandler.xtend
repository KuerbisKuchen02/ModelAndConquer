package commands

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.handlers.HandlerUtil
import ModelAndConquer.presentation.ModelAndConquerEditor
import org.eclipse.core.resources.IProject
import org.eclipse.ui.IFileEditorInput
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.TreeSelection

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
		
		var root = ts.firstElement		
		
		return void
	}
	
	
	
}