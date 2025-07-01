package commands;

import ModelAndConquer.presentation.ModelAndConquerEditor;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class GeneratorHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    InputOutput.<String>println("Generator starting...");
    final IWorkbenchPart wbp = HandlerUtil.getActivePart(event);
    ModelAndConquerEditor ue = ((ModelAndConquerEditor) wbp);
    IEditorInput _editorInput = ue.getEditorInput();
    IProject project = ((IFileEditorInput) _editorInput).getFile().getProject();
    ISelection _selection = ue.getSelection();
    TreeSelection ts = ((TreeSelection) _selection);
    Object root = ts.getFirstElement();
    return void.class;
  }
}
