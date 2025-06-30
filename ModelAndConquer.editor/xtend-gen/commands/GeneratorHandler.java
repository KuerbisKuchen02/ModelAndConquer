package commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class GeneratorHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    return InputOutput.<Object>println("Generator starting...");
  }
}
