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


# driver = webdriver.Chrome()
# driver.get('https://python.org')


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
# Login, Navigate Footer links 
runTest = True

if runTest:
    # LOGIN 
    Login(browser, pause, 'American', 'abc12345')
    print('LogIn Successful')
    fPause(2)
    
    # NAVIGATING TO HOME PAGE
    Nav(browser, By, pause, "Home")
    print('Landed on Home Page Successful')
    fPause(2)
    
    # REFRESH THE PAGE TO CLOSE THE SMART SCHEDULAR POP UP WINDOW
    browser.refresh()
    fPause(7)

    # Navigating to bottom of the page and to locate the footer links
    html = browser.find_element_by_tag_name('html')
    html.send_keys(Keys.END)
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # Clicking on TermsOfUse
    buttonlink = browser.find_element_by_xpath('//html/body/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div[2]/a/h5')
    buttonlink.click()
    print('SANITY PASS: Terms Of Use footer link opened in a separate window successfully')
    fPause(3)
    
    # NAVIGATING TO HOME PAGE
    Nav(browser, By, pause, "Home")
    fPause(1)
    print('SANITY PASS: landed on Home page Successful')
    fPause(2)
    
    # navigating to bottom of the page and to locate the footer links
    html = browser.find_element_by_tag_name('html')
    html.send_keys(Keys.END)
    
    # Clicking on Training
    buttonlink = browser.find_element_by_xpath('//html/body/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div[3]/a/h5')
    buttonlink.click()
    print('SANITY PASS: Training link opened in a separate window successfully')
    fPause(3)
    
    # navigating to bottom of the page and to locate the footer links
    html = browser.find_element_by_tag_name('html')
    html.send_keys(Keys.END)
    
    # Contact US should redirect to Portal helpdesk link
    buttonlink = browser.find_element_by_xpath('//html/body/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div[1]/a/h5')
    buttonlink.click()
    print('SANITY PASS: Contact US footer linked opened in separate window successfully')
    fPause(2)
    
    # CLOSING ALL THE BROWESER AND RETURNING TO HOME PAGE
    browser.switch_to.window(window_name=browser.window_handles[-1])
    browser.close()
    browser.switch_to.window(window_name=browser.window_handles[0])
    
    # NAVIGATING TO HOME PAGE
    Nav(browser, By, pause, "Home")
    fPause(1)
    print('SANITY PASS: landing on Home page Successful')
    
    # LOGGING OUT OF THE PAGE
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')