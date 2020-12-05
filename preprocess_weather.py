import pandas as pd
import numpy as np
import warnings
warnings.filterwarnings("ignore")
file_name = 'weather.csv'
df = pd.read_csv(file_name)
df_select = df[['Measurement Timestamp','Station Name','Air Temperature','Humidity','Total Rain']]
start_date = "2019-12-31"
end_date = "2020-12-31"
df_select['Measurement Timestamp'] = pd.to_datetime(df_select['Measurement Timestamp'])
filter = (df_select[(df_select['Measurement Timestamp']>start_date) & (df_select['Measurement Timestamp']<end_date)])
start = pd.DatetimeIndex(pd.to_datetime(filter['Measurement Timestamp']))
filter['Date'] = start.strftime("%m/%d/%Y")
res = filter.groupby('Date',as_index=False).agg('mean')
print(res.head(5))
res.to_csv(file_name.replace(".csv","")+"_processed.csv", sep=',',index=False,header=False)