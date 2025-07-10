package commands;

import ModelAndConquer.Area;
import ModelAndConquer.Connection;
import ModelAndConquer.DamageModificator;
import ModelAndConquer.DamageModificatorEffect;
import ModelAndConquer.DamageType;
import ModelAndConquer.DestroyableObject;
import ModelAndConquer.Effect;
import ModelAndConquer.EndGameEffect;
import ModelAndConquer.Game;
import ModelAndConquer.HealthEffect;
import ModelAndConquer.INonPlayerEntity;
import ModelAndConquer.Item;
import ModelAndConquer.Monster;
import ModelAndConquer.Player;
import ModelAndConquer.SpawnEffect;
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
    this.createFileWithContent(project, "models.generated", "Game.java", this.generateGame(game));
    this.createFileWithContent(project, "models.generated", "EDamageType.java", this.generateEDamageTypes(game.getDamageTypes()));
    return void.class;
  }

  public CharSequence generateGame(final Game game) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Game extends GenericElement {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Game(String name, String description) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(name, description);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.area = new Area[");
    int _size = game.getAreas().size();
    _builder.append(_size, "\t\t");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatePlayer = this.generatePlayer(game.getPlayer());
    _builder.append(_generatePlayer, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateAreas = this.generateAreas(game.getAreas());
    _builder.append(_generateAreas, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateConnections = this.generateConnections(game.getConnections());
    _builder.append(_generateConnections, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateEffects = this.generateEffects(game.getEffects());
    _builder.append(_generateEffects, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence generatePlayer(final Player player) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.player = new Player(\"");
    String _name = player.getName();
    _builder.append(_name);
    _builder.append("\", \"");
    String _description = player.getDescription();
    _builder.append(_description);
    _builder.append("\", ");
    double _maxHealth = player.getMaxHealth();
    _builder.append(_maxHealth);
    _builder.append(", null, null, null);");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generateAreas(final EList<Area> areas) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Generate Areas");
    _builder.newLine();
    {
      for(final Area area : areas) {
        _builder.append("// Generate Area ");
        String _name = area.getName();
        _builder.append(_name);
        _builder.newLineIfNotEmpty();
        _builder.append("// Generate INonPlayerEntities for ");
        String _name_1 = area.getName();
        _builder.append(_name_1);
        _builder.newLineIfNotEmpty();
        CharSequence _generateINonPlayerEntities = this.generateINonPlayerEntities(area.getEntities());
        _builder.append(_generateINonPlayerEntities);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("// Generate Items for ");
        String _name_2 = area.getName();
        _builder.append(_name_2);
        _builder.newLineIfNotEmpty();
        CharSequence _generateItems = this.generateItems(area.getItems());
        _builder.append(_generateItems);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("// Add Area object");
        _builder.newLine();
        _builder.append("this.areas.add(new Area(\"");
        String _name_3 = area.getName();
        _builder.append(_name_3);
        _builder.append("\", \"");
        String _description = area.getDescription();
        _builder.append(_description);
        _builder.append("\", null, entities, items, null));");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence generateConnections(final EList<Connection> connections) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Generate Connections");
    _builder.newLine();
    {
      for(final Connection connection : connections) {
        _builder.append("this.connections.add(new Connection(\"");
        String _name = connection.getName();
        _builder.append(_name);
        _builder.append("\", \"");
        String _description = connection.getDescription();
        _builder.append(_description);
        _builder.append("\", null, null, null, null);");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence generateEffects(final EList<Effect> effects) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Generate Effects");
    _builder.newLine();
    {
      for(final Effect effect : effects) {
        _builder.append("this.effects.add( ");
        _builder.newLine();
        {
          if ((effect instanceof HealthEffect)) {
            _builder.append("new HealthEffect(\"");
            String _name = ((HealthEffect)effect).getName();
            _builder.append(_name);
            _builder.append("\", \"");
            String _description = ((HealthEffect)effect).getDescription();
            _builder.append(_description);
            _builder.append("\", ");
            int _duration = ((HealthEffect)effect).getDuration();
            _builder.append(_duration);
            _builder.append(", ");
            double _amount = ((HealthEffect)effect).getAmount();
            _builder.append(_amount);
            _builder.append(", ");
            boolean _isOnSelf = ((HealthEffect)effect).isOnSelf();
            _builder.append(_isOnSelf);
            _builder.append(", null)");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          if ((effect instanceof SpawnEffect)) {
            _builder.append("new SpawnEffect(\"");
            String _name_1 = ((SpawnEffect)effect).getName();
            _builder.append(_name_1);
            _builder.append("\", \"");
            String _description_1 = ((SpawnEffect)effect).getDescription();
            _builder.append(_description_1);
            _builder.append("\", null, null)");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          if ((effect instanceof DamageModificatorEffect)) {
            _builder.append("new DamageModificatorEffect(\"");
            String _name_2 = ((DamageModificatorEffect)effect).getName();
            _builder.append(_name_2);
            _builder.append("\", \"");
            String _description_2 = ((DamageModificatorEffect)effect).getDescription();
            _builder.append(_description_2);
            _builder.append("\", null, ");
            boolean _isOnSelf_1 = ((DamageModificatorEffect)effect).isOnSelf();
            _builder.append(_isOnSelf_1);
            _builder.append(")");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          if ((effect instanceof EndGameEffect)) {
            _builder.append("new EndGameEffect(\"");
            String _name_3 = ((EndGameEffect)effect).getName();
            _builder.append(_name_3);
            _builder.append("\", \"");
            String _description_3 = ((EndGameEffect)effect).getDescription();
            _builder.append(_description_3);
            _builder.append("\")");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append(");");
        _builder.newLine();
      }
    }
    return _builder;
  }

  public CharSequence generateINonPlayerEntities(final EList<INonPlayerEntity> entities) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Generate Non Player Entities");
    _builder.newLine();
    _builder.append("ArrayList<INonPlayerEntity> entities = new ArrayList<INonPlayerEntity>();");
    _builder.newLine();
    {
      for(final INonPlayerEntity entity : entities) {
        {
          if ((entity instanceof Monster)) {
            _builder.append("// Generate Inventory of Monster ");
            String _name = ((Monster)entity).getName();
            _builder.append(_name);
            _builder.newLineIfNotEmpty();
            CharSequence _generateItems = this.generateItems(((Monster)entity).getInventory());
            _builder.append(_generateItems);
            _builder.newLineIfNotEmpty();
            _builder.append("// Generate DamageModificators of Monster ");
            String _name_1 = ((Monster)entity).getName();
            _builder.append(_name_1);
            _builder.newLineIfNotEmpty();
            CharSequence _generateDamageModificator = this.generateDamageModificator(((Monster)entity).getDamageModificators());
            _builder.append(_generateDamageModificator);
            _builder.newLineIfNotEmpty();
            _builder.append("Entity entity = new Monster(\"");
            String _name_2 = ((Monster)entity).getName();
            _builder.append(_name_2);
            _builder.append("\", \"");
            String _description = ((Monster)entity).getDescription();
            _builder.append(_description);
            _builder.append("\", ");
            double _maxHealth = ((Monster)entity).getMaxHealth();
            _builder.append(_maxHealth);
            _builder.append(", items, null, null, null, null, null, null, null)");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((entity instanceof DestroyableObject)) {
            _builder.append("// Generate Inventory of Destroyable Object ");
            String _name_3 = ((DestroyableObject)entity).getName();
            _builder.append(_name_3);
            _builder.newLineIfNotEmpty();
            CharSequence _generateItems_1 = this.generateItems(((DestroyableObject)entity).getInventory());
            _builder.append(_generateItems_1);
            _builder.newLineIfNotEmpty();
            _builder.append("// Generate DamageModificators of DestroyableObject ");
            String _name_4 = ((DestroyableObject)entity).getName();
            _builder.append(_name_4);
            _builder.newLineIfNotEmpty();
            CharSequence _generateDamageModificator_1 = this.generateDamageModificator(((DestroyableObject)entity).getDamageModificators());
            _builder.append(_generateDamageModificator_1);
            _builder.newLineIfNotEmpty();
            _builder.append("Entity entity = new DestroyableObject(\"");
            String _name_5 = ((DestroyableObject)entity).getName();
            _builder.append(_name_5);
            _builder.append("\", \"");
            String _description_1 = ((DestroyableObject)entity).getDescription();
            _builder.append(_description_1);
            _builder.append("\", ");
            double _maxHealth_1 = ((DestroyableObject)entity).getMaxHealth();
            _builder.append(_maxHealth_1);
            _builder.append(",  items, null, null);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("entities.add(entity);");
        _builder.newLine();
      }
    }
    return _builder;
  }

  public CharSequence generateItems(final EList<Item> items) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Generate items");
    _builder.newLine();
    _builder.append("ArrayList<Item> items = new ArrayList<Item>();");
    _builder.newLine();
    {
      for(final Item item : items) {
        _builder.append("items.add(new Item(\"");
        String _name = item.getName();
        _builder.append(_name);
        _builder.append("\", \"");
        String _description = item.getDescription();
        _builder.append(_description);
        _builder.append("\", ");
        double _damage = item.getDamage();
        _builder.append(_damage);
        _builder.append(", ");
        boolean _isConsumable = item.isConsumable();
        _builder.append(_isConsumable);
        _builder.append(", null, null, null, null);");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence generateDamageModificator(final EList<DamageModificator> damageModificators) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Generate DamageModificator");
    _builder.newLine();
    _builder.append("ArrayList<DamageModificator> damageModificators = new ArrayList<DamagaModificator>();");
    _builder.newLine();
    {
      for(final DamageModificator damageModificator : damageModificators) {
        _builder.append("DamageModificator damageModificator = new DamageModificator(");
        String _name = damageModificator.getName();
        _builder.append(_name);
        _builder.append(", ");
        String _description = damageModificator.getDescription();
        _builder.append(_description);
        _builder.append(", null, ");
        double _multiplikator = damageModificator.getMultiplikator();
        _builder.append(_multiplikator);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("damageModificators.add(damageModificator);");
        _builder.newLine();
      }
    }
    _builder.newLine();
    return _builder;
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
        _builder.append(" -> \"");
        String _name = damageTypes.get(i_1).getName();
        _builder.append(_name, "\t\t\t");
        _builder.append("\"");
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
