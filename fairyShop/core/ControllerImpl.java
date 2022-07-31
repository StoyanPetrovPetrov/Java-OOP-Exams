package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.helpers.BaseHelper;
import fairyShop.models.helpers.Happy;
import fairyShop.models.helpers.Helper;
import fairyShop.models.helpers.Sleepy;
import fairyShop.models.instruments.Instrument;
import fairyShop.models.instruments.InstrumentImpl;
import fairyShop.models.presents.Present;
import fairyShop.models.presents.PresentImpl;
import fairyShop.models.shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

public class ControllerImpl implements Controller{
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        BaseHelper helper = null;
        switch (type){
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER,type,helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);

        if(helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);

    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);

    }

    @Override
    public String craftPresent(String presentName) {
        BaseHelper helper = helperRepository.getModels().stream().filter(s -> s.getEnergy() > 50).findFirst().orElse(null);
        if(helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        Present present = presentRepository.findByName(presentName);

        ShopImpl shop = new ShopImpl();
        shop.craft(present, helper);

        String done = present.isDone() ? "done" : "not done";

        return String.format(ConstantMessages.PRESENT_DONE + ConstantMessages.COUNT_BROKEN_INSTRUMENTS, presentName, done, helper.getBrokenInstrument());
    }

    @Override
    public String report() {
        return presentRepository.getModels().stream().filter(Present::isDone).count() + " presents are done!" + System.lineSeparator() +
                "Helpers info:" + ((helperRepository.getModels().size() == 0) ? "" : System.lineSeparator() +
                helperRepository.toString());
    }
}
