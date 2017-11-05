package provider.earnings;

import earnings.EarningsProvider;
import model.Earning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.earning.EarningService;
import util.MyIOUtil;

/**
 * @author fangxin
 * @date 2017/11/5.
 */
@Service
public class EarningsProviderImpl implements EarningsProvider {

    @Autowired
    private EarningService earningService;

    @Override
    public boolean savePDF(String filePath) {
        String text = MyIOUtil.getTextFromPDF(filePath);

        Earning earning = new Earning();
        earning.setCompany("asdf")
                .setText(text);

        earningService.insert(earning);
        return true;
    }

}
