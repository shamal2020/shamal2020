# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
import time

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
#     Add webdrivers as needed (edge / chrome / firefox)
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

#Login, go to home and fleet overview, logout
#Login, go to home and fleet overview, validate count for each Fleet summary card is correct,search vessel name and erase vessel name
runTest = True
if runTest:
    # Logging in the Customer Portal
    Login(browser, pause, 'Fortunato', 'abc12345')
    print('SANITY PASS:Login Successful')
    fPause(2)
    
    # Navigating to Home Page
    Nav(browser, By, pause, "Home")
    print('SANITY PASS:LANDED IN HOME PAGE Successful')
    fPause(2)
    
    # REFRESH THE PAGE TO CLOSE THE SMART SCHEDULAR POP UP WINDOW
    browser.refresh()
    fPause(7)
    
    # Navigating to Fleet Overview Page
    Nav(browser, By, pause, "Fleet Overview")
    pause()
    print('SANITY PASS:LANDED ON FLEET OVERVIEW PAGE Successful')
    
    # TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # CLOSING THE FLEET VIEW ICON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[1]')
    button.click()
    print('SANITY PASS: CLOSED THE FLEET VIEW ICON')
    
    # Calculating Total number of Cards in the FleetOverview Page and clicking on the Total Filter
    values = browser.find_element_by_css_selector(".statistics-buttons-active .btn")
    buttonValue = values.text
    pause()
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("CLICKING ON TOTAL NUMBER OF VESSELS FILTER")
    print("--------------")
    pause()
    
    # Validating the total count of Total number of vessels Filter
    allButtons = browser.find_elements_by_css_selector(".FleetSummaryCard .statistics-buttons")
    allButtons[1].click()
    print('SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR TOTAL NUMBER OF VESSEL')
#     buttonValue = allButtons[1].text
#     buttonValue = buttonValue.lstrip("0")
#     fPause(2)
#     getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
#     print(buttonValue)
#     print(len(getAllCards))
#     if str(len(getAllCards)) != str(buttonValue):
#         print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
#     else:
#         print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR TOTAL NUMBER OF VESSEL")
#     print("--------------")
#     fPause(2)

    # Validating the total count of OVERDUE SURVEY/AUDITS Filter
    button = browser.find_element_by_xpath('//main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    fPause(2)
    print('CLICKING ON OVERDUE SURVEY/AUDITS FILTER')
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR OVERDUE SURVEY/AUDIT")
    print("--------------")
    
    # Validating the total count of DUE SURVEY/AUDITS Filter
    button = browser.find_element_by_xpath("//main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/button")
    button.click()
    print('CLICKING ON DUE SURVEY/AUDIT FILTER')
    fPause(4)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    fPause(3)
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR DUE SURVEY/AUDIT")
    print("--------------") 
    
    # Validating the total count of OVERDUE FINDINGS Filter  
    button =browser.find_element_by_xpath('//main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/div[2]/div[1]/button')
    button.click()
    print('CLICKING ON OVERDUE FINDINGS FILTER')
    fPause(3)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    fPause(3)
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR OVERDUE FINDINGS")
    print("--------")
    
    # Validating the total count of DUE FINDINGS Filter
    button =browser.find_element_by_xpath('//main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/button')
    button.click()
    fPause(3)
    print('CLICKING ON DUE FINDINGS FILTER')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    fPause(3)
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR DUE FINDINGS")
    print("--------------")
    
    # Validating the total count of SUBMITTED ATTENDANCE Filter
    button =browser.find_element_by_xpath('//main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/div[1]/button')
    button.click()
    fPause(2)
    print('CLICKING ON SUBMITTED ATTENDANCE FILTER')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    if button.text == "":
        button.text = "0"
    fPause(2) 
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR SUBMITTED ATTENDANCE")
    print("--------------")
    
    # Validating the total count of IN PROGRESS ATTENDANCE Filter
    button =browser.find_element_by_xpath('//main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/div[2]/button')
    button.click()
    fPause(2)
    print('CLICKING ON IN PROGRESS ATTENDANCE FILTER')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    fPause(2)
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR In PROGRESS ATTENDANCE")
    print("--------------")
    fPause(2)
    
    # Validating the total count of EXPIRING WITHIN 180 DAYS Filter
    button =browser.find_element_by_xpath('//main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[5]/div[2]/button')
    button.click()
    fPause(2)
    print('CLICKING ON EXPIRING WITHIN 180 DAYS FILTER')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    fPause(2)
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY")
    else:
        print("SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR EXPIRING WITHIN 180 DAYS FILTER")
    print("--------------")
    fPause(2)
    
    # CLICKING ON EXCLUDE LAID UP VESSEL TOGGLE BUTTON
    span = browser.find_elements_by_xpath('//main/div/div[1]/div[2]/div[2]/div/div/label/span')
    span[0]. click()
    fPause(2)
    print('SANITY PASS:Exclude laid-up Vessels option Turned On')
    
    # CLICKING ON INCLUDE LAID UP VESSEL TOGGLE BUTTON
    span[0]. click()
    fPause(2)
    print('SANITY PASS:Exclude laid-up Vessels option Turned Off')
    
    # CLICKING ON FLEET TIMELINE BUTTON
    togglebtn1= browser.find_elements_by_xpath('//main/div/div[1]/div[2]/div[3]/div/div/label[2]')
    fPause(2)
    print('SANITY PASS:Fleet Timeline page displayed')
    fPause(2)
     
    # CLICKING ON FLEETOVERVIEW CARD BUTTON
    togglebtn2= browser.find_elements_by_xpath('//main/div/div[1]/div[2]/div[3]/div/div/label[1]')
    fPause(2)
    print('SANITY PASS:Fleet Overview page with Cards displayed in Fleet Overview page')
    
    # SEARCHING FOR A VESSEL BY ENTERING A NAME
    searchinput = browser.find_element_by_xpath('//*[@id="searchinput"]')
    searchinput.send_keys("PERRO NEGRO 5")
    fPause(3)
    print('SANITY PASS:Search by Vessel name Successful')
    
    # CLEARING THE ENTERED VESSEL NAME
    Searchicon = browser.find_elements_by_xpath('//main/div/div[1]/div[2]/div[4]/div/span')
    Searchicon[0].click()
    fPause(2)
    print('SANITY PASS:Erase Vessel name Successful')
    fPause(1)
    
    # LOGGING OUT OF CUSTOMER PORTAL
    Logout(browser, pause)
    print('SIT PASS:Fleet Overview page Sanity Test Successful')
