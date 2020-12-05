import pandas as pd
import numpy as np
from datetime import datetime
import warnings
warnings.filterwarnings("ignore")
file_name = 'COVID.csv'
df = pd.read_csv(file_name)
res= df[['Date','Day','People Tested - Total','People Positive - Total']]
res.columns = ['Date','Weekday','Test','Positive']

start = pd.DatetimeIndex(pd.to_datetime(res['Date']))
res['Month'] = start.strftime("%m")
res['Day'] = start.strftime("%d")
print(res.head(5))
res.to_csv(file_name.replace(".csv","")+"_processed.csv", sep=',',index=False,header=False)