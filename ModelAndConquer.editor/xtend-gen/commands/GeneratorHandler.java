package commands;

import ModelAndConquer.DamageType;
import ModelAndConquer.Game;
import ModelAndConquer.presentation.ModelAndConquerEditor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

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
    Object _firstElement = ts.getFirstElement();
    Game game = ((Game) _firstElement);
    this.createFileWithContent(project, "models", "EDamageType.java", this.generateEDamageTypes(game.getDamageTypes()));
    return void.class;
  }

  public CharSequence generateEDamageTypes(final EList<DamageType> damageTypes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public enum EDamageType {");
    _builder.newLine();
    {
      int _size = damageTypes.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      boolean _hasElements = false;
      for(final int i : _upTo) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("\t");
        String _upperCase = damageTypes.get(i).getName().toUpperCase();
        _builder.append(_upperCase, "\t");
        _builder.append("(");
        _builder.append(i, "\t");
        _builder.append(")");
        {
          int _size_1 = damageTypes.size();
          int _minus_1 = (_size_1 - 1);
          boolean _equals = (i == _minus_1);
          if (_equals) {
            _builder.append(";");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private final int value;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EDamageType(int value) { this.value=value; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static String getValueString(int value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return switch (value) {");
    _builder.newLine();
    {
      int _size_2 = damageTypes.size();
      int _minus_2 = (_size_2 - 1);
      IntegerRange _upTo_1 = new IntegerRange(0, _minus_2);
      for(final int i_1 : _upTo_1) {
        _builder.append("\t\t\t");
        _builder.append("case ");
        _builder.append(i_1, "\t\t\t");
        _builder.append(" -> ");
        String _name = damageTypes.get(i_1).getName();
        _builder.append(_name, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("default -> \"Not an valid DamageType!\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public void createFileWithContent(final IProject project, final String pckgName, final String fileName, final CharSequence content) {
    try {
      String currentFolderString = "src-gen/";
      IFolder folder = null;
      folder = project.getFolder("src-gen");
      boolean _exists = folder.exists();
      boolean _not = (!_exists);
      if (_not) {
        folder.create(true, true, null);
      }
      String[] _split = pckgName.split("\\.");
      for (final String n : _split) {
        {
          currentFolderString = ((currentFolderString + n) + "/");
          folder = project.getFolder(currentFolderString);
          boolean _exists_1 = folder.exists();
          boolean _not_1 = (!_exists_1);
          if (_not_1) {
            folder.create(true, true, null);
          }
        }
      }
      IFile file = folder.getFile(fileName);
      boolean _exists_1 = file.exists();
      if (_exists_1) {
        file.delete(true, null);
      }
      boolean _exists_2 = file.exists();
      boolean _not_1 = (!_exists_2);
      if (_not_1) {
        byte[] bytes = null;
        bytes = content.toString().getBytes();
        InputStream source = new ByteArrayInputStream(bytes);
        file.create(source, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
