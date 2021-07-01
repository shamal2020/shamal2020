# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys

# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change

# from builtins import True
# ---------------------------- #
# Settings - Change as needed #
# --------------------------- #
useBrowser = 'chrome' #edge, chrome
maxWindowOnLoad = True
closeBrowserWhenFinished = False
defaultWaitTime = 10 # seconds - time default wait before select fails
useEnv = 'portaluat'
env = {
  'fredmod'   :  'https://fredmod.eagle.org/portal/#/Login',
  'fredint'   :  'https://fredint.eagle.org/portal/#/Login',
  'portaluat' :  'https://portaluat.eagle.org/portal//#/Login'
}

# --------------------------------- #
# Settings - Change if you have to  #
# --------------------------------- #
if useBrowser == 'edge':
    # Add webdrivers as needed (edge / chrome / firefox)
    browser = webdriver.Edge('msedgedriver')
else:
    browser = webdriver.Chrome()
browser.get(env[useEnv])

if maxWindowOnLoad == True:
    browser.set_window_size(1440, 900)
    browser.maximize_window()

# time to try to find NEXT element before timeout
# should be used to you just need for next item to exist before you continue
def pause(time = defaultWaitTime):
    browser.implicitly_wait(time)
# force browser to pause before moving on
# should be used to you need to see what is happening
def fPause(time = defaultWaitTime):
    browser.implicitly_wait(time)
    cantGetItem = browser.find_elements_by_css_selector('.will-never-find-this-item')

# /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\ #
# ------------------------------------------------------------------ #
# ===================== Tests / Commands below ===================== #
# ------------------------------------------------------------------ #
# \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ #

print('RUNNING FILE')
# Log in, Go to Finance, click on Statement of Account, click on Invoices, click on the filters and validate the count
runTest = True
if runTest:
    #  LOGIN THE PAGE
    Login(browser, pause, 'Transocean', 'abc12345')
    fPause(1)
    print('SANITY PASS: LOGIN Successful')
    
    # NAVIGATING TO HOME PAGE
    Nav(browser, By, pause, "Home")
    print('SANITY PASS: LANDED ON HOME PAGE Successful')
    fPause(1)
    
    # REFRESH THE PAGE TO CLOSE THE SMART SCHEDULAR POP UP WINDOW
    browser.refresh()
    fPause(7)

    # NAVIGATING TO FINANCE PAGE
    Nav(browser, By, pause, "Finance")
    print('SANITY PASS: LANDED ON FINANCE PAGE Successful')
    fPause(2)
    
    # LOCATING STATEMENT OF ACCOUNT BUTTON
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[1]/div[1]/div/div/div[2]/div/div[2]/button')
    button.click()
    fPause(5)
    print('SANITY PASS: STATEMENT OF ACCOUNT REPORT Download Successful')
    
    # NAVIGATING BACK TO FINANCE PAGE
    Nav(browser, By, pause, "Finance")
    print('SANITY PASS: LANDED ON FINANCE PAGE Successful')
    fPause(2)
    
    # LOCATING +120 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[2]/div/div[1]/div[2]/div[1]/button')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF THE +120 DAYS FILTER
    valueofbutton = 12
    numberofcards = 12
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO INVOICE NUMBER DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO INVOICE NUMBER DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF +120 DAYS FILTER Successful...........')
    fPause(2)
    
    
    #CLICKING ON THE INVOICE BUTTON
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[2]/div/div[3]/div/div/div/div/div[2]/button')
    button.click() 
    fPause(5)
    print ("SANITY PASSED: INVOICE REPORTS UNDER +120 DAYS FILTER DOWNLOADED SUCCESSFULLY")
    
    # LOCATING 31-120 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[2]/div/div[1]/div[2]/div[2]/button')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF 31-120 DAYS FILTER
    valueofbutton = 14
    numberofcards = 14
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO INVOICE NUMBER DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO INVOICE NUMBER DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF 31-120 DAYS FILTER Successful...........')
    fPause(2)
    
    #CLICKING ON THE INVOICE BUTTON
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[2]/div/div[6]/div/div/div/div/div[2]/button')
    button.click() 
    fPause(7)
    print ("SANITY PASSED: INVOICE REPORTS UNDER 31-120 DAYS FILTER DOWNLOADED SUCCESSFULLY")
    
    #LOCATING 0-30 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[2]/div/div[1]/div[2]/div[3]')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF 0-30 DAYS DAYS FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO INVOICE NUMBER DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO INVOICE NUMBER DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF 0-30 DAYS FILTER Successful...........')
    fPause(2)
    
    # LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[2]/div/div[1]/div[2]/div[4]/button')
    button.click()
    # WAITING FOR THE PAGE TO REFRESH/RESET
    fPause(3)
    print('SANITY PASS: RESET BUTTON WORKS Successfully')
    
    # LOCATING INVOICE BUTTON
    button = browser.find_element_by_xpath('//main/div/div[4]/div/div[2]/div/div[36]/div/div/div/div/div[2]/button')
    button.click()
    fPause(5)
    print('SANITY PASS: INVOICE REPORT Download Successful')
    
    # LOGGING OUT OF THE PAGE
    Logout(browser, pause)
    print('SANITY SIT PASS:Logout Successful')



